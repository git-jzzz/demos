package com.demos.musicmanager.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demos.musicmanager.pojo.bo.MusicBO;
import com.demos.musicmanager.pojo.entity.Music;
import com.demos.musicmanager.mapper.MusicMapper;
import com.demos.musicmanager.pojo.vo.MusicVO;
import com.demos.musicmanager.service.MusicService;
import com.demos.musicmanager.service.QiniuService;
import com.demos.musicmanager.util.enums.ResultEnums;
import com.demos.musicmanager.util.response.ResponseData;
import com.demos.musicmanager.util.response.ResponseDataUtil;
import com.demos.musicmanager.util.url.URLUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.sql.Struct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private QiniuService qiniuService;

    //七牛云外链域名
    private static String qiniu_wailianURL = "http://qny.jzai.xyz/";


    //music.js路径
    private static String musicjsPath_hexo = "D:\\hexo\\source\\dist\\music.js";

    //本地备份路径
    private static String backups_path = "D:\\File\\Music\\";


    //咪咕歌曲信息url
    private static String migu_song_url = "https://music.migu.cn/v3/api/music/audioPlayer/songs?type=1&copyrightId=";
    //歌词url
    private static String migu_lrc_url = "https://music.migu.cn/v3/api/music/audioPlayer/getLyric?copyrightId=";
    //封面url
    private static String migu_cover_url = "https://music.migu.cn/v3/api/music/audioPlayer/getSongPic?songId=";


    //网易云接口信息
    //歌曲接口
    private static String wangyiyun_song_url = "https://music.163.com/song/media/outer/url?id=";
    //歌词接口
    private static String wangyiyun_lrc_url = "http://music.163.com/api/song/media?id=";

    /**
     * 获取咪咕音乐链接  存入七牛云&数据库
     *
     * @param musicBO
     * @return
     */
    @Override
    public ResponseData addMusic(MusicBO musicBO) throws Exception {
        if (musicBO.getStatus() == 2) {
            String result = URLUtils.httpGet(musicBO.getUrl());
            JSONObject jsonObject = JSONUtil.parseObj(result);
            //获取歌曲链接
            String song_url = "http:" + jsonObject.getJSONObject("data").getStr("playUrl");
            //获取copyrightId
            String copyrightId = StrUtil.sub(song_url, song_url.indexOf("CI=") + 3, song_url.indexOf("CI=") + 14);

            log.info("copyrightId:{}", copyrightId);
            //获取歌词
            String lrcResult = URLUtils.httpGet(migu_lrc_url + copyrightId);
            String lrc = JSONUtil.parseObj(lrcResult).getStr("lyric");
            //获取歌曲信息
            String songResult = URLUtils.httpGet(migu_song_url + copyrightId);
            JSONObject jsonObject1 = JSONUtil.parseObj(songResult).getJSONArray("items").getJSONObject(0);
            String songId = jsonObject1.getStr("songId");
            String songName = jsonObject1.getStr("songName");
            String author = jsonObject1.getJSONArray("singers").getJSONObject(0).getStr("artistName");

            //获取封面图地址
            String coverResult = URLUtils.httpGet(migu_cover_url + songId);
            String cover = "http:" + JSONUtil.parseObj(coverResult).getStr("smallPic");

            InputStream inputStream1 = URLUtils.getInputStreamByUrl(song_url);
            InputStream inputStream2 = URLUtils.getInputStreamByUrl(cover);
            InputStream inputStream3 = URLUtils.getStreamByString(lrc);
            if (inputStream1 == null || inputStream2 == null || inputStream3 == null) {
                return ResponseDataUtil.buildError(ResultEnums.NULL_ERROR);
            }
            String names = songName + "-" + author;
            names = names.replace("/", "");
            String result1 = qiniuService.uploadFile(inputStream1, names + ".mp3");
            String result2 = qiniuService.uploadFile(inputStream2, names + ".jpg");
            String result3 = qiniuService.uploadFile(inputStream3, names + ".lrc");

            inputStream1 = URLUtils.getInputStreamByUrl(song_url);
            inputStream2 = URLUtils.getInputStreamByUrl(cover);
            inputStream3 = URLUtils.getStreamByString(lrc);

            System.out.println(result1 + "\n" + result2 + "\n" + result3);
            Music music = new Music(null, songName, author, result1, result3, result2, 1);
            MusicVO musicVO = new MusicVO(music.getSongName(), music.getSongAuthor(), music.getSongUrl(), music.getLrcUrl(), music.getCoverUrl());
            //存入本地文件夹备份
            backups(inputStream1, inputStream2, inputStream3, names + ".mp3", names + ".jpg", names + ".lrc");
            //写入music.js
            addMusicJS(musicVO);
            //存入数据库
            int i = musicMapper.addMusic(music);
            return ResponseDataUtil.buildSuccess(i > 0 ? "上传成功" : "上传失败");
        } else if (musicBO.getStatus() == 1) {
            //网易云
            InputStream inputStream = URLUtils.getInputStreamByUrl(URLUtils.getLocation(wangyiyun_song_url + musicBO.getWyyId()));
            InputStream inputStream1 = URLUtils.getInputStreamByUrl(wangyiyun_song_url + musicBO.getWyyId());

        }

        return ResponseDataUtil.buildSuccess("success");
    }

    @Override
    public ResponseData imports() throws Exception {
        List<MusicVO> musicVOList = musicMapper.imports();
        for (int i = 0; i < musicVOList.size(); i++) {
            MusicVO musicVO = musicVOList.get(i);
            InputStream inputStream1 = URLUtils.getInputStreamByUrl(URLUtils.getLocation(musicVO.getUrl()));
            InputStream inputStream2 = URLUtils.getInputStreamByUrl(musicVO.getCover());
            InputStream inputStream3 = URLUtils.getInputStreamByUrl(musicVO.getLrc());
            String names = musicVO.getName() + "-" + musicVO.getArtist();
            names = names.replace("/", "");

            String result1 = qiniuService.uploadFile(inputStream1, names + ".mp3");
            String result2 = qiniuService.uploadFile(inputStream2, names + ".jpg");
            String result3 = qiniuService.uploadFile(inputStream3, names + ".lrc");

            inputStream1 = URLUtils.getInputStreamByUrl(URLUtils.getLocation(musicVO.getUrl()));
            inputStream2 = URLUtils.getInputStreamByUrl(musicVO.getCover());
            inputStream3 = URLUtils.getInputStreamByUrl(musicVO.getLrc());
            log.debug("result1：" + result1 + "\n" + "result2：" + result2 + "\n" + "result3：" + result3);

            Music music = new Music(null, musicVO.getName(), musicVO.getArtist(), result1, result3, result2, 1);
            //存入本地文件夹备份
            backups(inputStream1, inputStream2, inputStream3, names + ".mp3", names + ".jpg", names + ".lrc");
            MusicVO musicVOs = new MusicVO(music.getSongName(), music.getSongAuthor(), result1, result3, result2);
            //写入music.js
            addMusicJS(musicVOs);
            //存入数据库
            musicMapper.addMusic(music);
        }
        return ResponseDataUtil.buildSuccess();
    }

    //写入music.js
    public void addMusicJS(MusicVO musicVO) throws Exception {
        FileReader fileReader = new FileReader("D:\\hexo\\source\\dist\\music.js");
        String result = fileReader.readString();
        int start = result.indexOf("\"audio\": ") + 9;
        int end = result.indexOf("});") - 1;
        String json = StrUtil.sub(result, start, end);
        JSONArray jsonArray = JSONUtil.parseArray(json);
        jsonArray.add(musicVO);
        result = StrUtil.replace(result, json, jsonArray.toString());
        FileWriter fileWriter = new FileWriter("D:\\hexo\\source\\dist\\music.js");
        fileWriter.write(result);
        System.out.println(result);
    }

    //备份到本地
    public void backups(InputStream inputStream1, InputStream inputStream2, InputStream inputStream3, String path1, String path2, String path3) {
        FileUtil.writeFromStream(inputStream1, backups_path + path1);
        FileUtil.writeFromStream(inputStream2, backups_path + path2);
        FileUtil.writeFromStream(inputStream3, backups_path + path3);
    }
}