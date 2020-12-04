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
import java.util.Map;


@Service
@Slf4j
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private QiniuService qiniuService;

    //七牛云外链域名
    private static String qiniu_wailianURL="http://qny.jzai.xyz/";


    //music.js路径
    private static  String musicjsPath_hexo="D:\\hexo\\source\\dist\\music.js";

    //本地备份路径
    private static String backups_path="D:\\File\\Music";


    //歌曲信息url
    private static String migu_song_url = "https://music.migu.cn/v3/api/music/audioPlayer/songs?type=1&copyrightId=";
    //歌词url
    private static String migu_lrc_url = "https://music.migu.cn/v3/api/music/audioPlayer/getLyric?copyrightId=";
    //封面url
    private static String migu_cover_url = "https://music.migu.cn/v3/api/music/audioPlayer/getSongPic?songId=";


    /**
     * 获取咪咕音乐链接  存入七牛云&数据库
     *
     * @param musicBO
     * @return
     */
    @Override
    public ResponseData addMusic(MusicBO musicBO) throws Exception {
        MusicVO musicVO=new MusicVO("晴天-周杰伦","周杰伦","http://qny.jzai.xyz/晴天-周杰伦.mp3","http://qny.jzai.xyz/晴天-周杰伦.lrc","http://qny.jzai.xyz/晴天-周杰伦.jpg");

        addMusicJS(musicVO);
        if (true){
        return ResponseDataUtil.buildSuccess("1");}
        Music music = new Music();
        if (musicBO.getStatus() == 2) {
            String result = URLUtils.httpGet(musicBO.getUrl());
            JSONObject jsonObject = JSONUtil.parseObj(result);
            //获取歌曲链接
            String song_url = "http:" + jsonObject.getJSONObject("data").getStr("playUrl");
            //获取copyrightId
            String copyrightId = StrUtil.sub(song_url, song_url.indexOf(".mp3") - 17, song_url.indexOf(".mp3") - 6);
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
            System.out.println("get success");

            InputStream inputStream1 = URLUtils.getInputStreamByUrl(song_url);
            InputStream inputStream2 = URLUtils.getInputStreamByUrl(cover);
            InputStream inputStream3 = URLUtils.getStreamByString(lrc);
            Map<String,InputStream> map=new HashMap<>();
            if (inputStream1 == null || inputStream2 == null || inputStream3 == null) {
                return ResponseDataUtil.buildError(ResultEnums.NULL_ERROR);
            }

            String result1 = qiniuService.uploadFile(inputStream1, songName + "-" + author + ".mp3");
            String result2 = qiniuService.uploadFile(inputStream2, songName + "-" + author + ".jpg");
            String result3 = qiniuService.uploadFile(inputStream3, songName + "-" + author + ".lrc");
            System.out.println(result1 + "\n" + result2 + "\n" + result3);
            //存入本地文件夹备份

            //写入music.js

            //存入数据库
            music.setSongName(songName);
            music.setSongAuthor(author);
            music.setCoverUrl(songName + "-" + author + ".jpg");
            music.setLrcUrl(songName + "-" + author + ".lrc");
            music.setSongUrl(songName + "-" + author + ".mp3");
            music.setStatus(1);
        }

        return ResponseDataUtil.buildSuccess("1");
//        return ResponseDataUtil.buildSuccess(musicMapper.addMusic(music));
    }

    public void addMusicJS(MusicVO musicVO) throws  Exception{
        FileReader fileReader=new FileReader("D:\\hexo\\source\\dist\\music.js");
        String result=fileReader.readString();
        int start = result.indexOf("\"audio\": ") + 9;
        int end = result.indexOf("});") - 1;
        String json=StrUtil.sub(result,start,end);
        JSONArray jsonArray =JSONUtil.parseArray(json);
        jsonArray.add(musicVO);
       result=StrUtil.replace(result, json, jsonArray.toString());
        FileWriter fileWriter=new FileWriter("D:\\hexo\\source\\dist\\music.js");
        fileWriter.write(result);
        System.out.println(result);
    }



    //本地文件备份
    public void backups(InputStream inputStream1,InputStream inputStream2,InputStream inputStream3){
//        FileUtil.writeFromStream(inputStream1, )
    }
}