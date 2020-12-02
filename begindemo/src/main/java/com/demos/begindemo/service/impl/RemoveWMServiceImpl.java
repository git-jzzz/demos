package com.demos.begindemo.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demos.begindemo.service.RemoveWMService;
import com.demos.begindemo.util.response.ResponseData;
import com.demos.begindemo.util.response.ResponseDataUtil;
import com.demos.begindemo.util.url.RedirectUrl;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jz
 * @Date: 2020/11/30 13:58
 * @Description:  获取无水印视频url
 */
@Service
public class RemoveWMServiceImpl  implements RemoveWMService {

    //抖音接口
    public static String DOU_YIN_BASE_URL = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";


    @Override
    public ResponseData rmwm(String url) throws Exception {
        url= URLDecoder.decode(url).replace("url=", "");
        //重定向URL
        String redirectURL= RedirectUrl.getLocation(url);
        Map<String,Object> map=new HashMap<>();
        if(!StrUtil.isEmpty(redirectURL)){

            //获取itemId
            String itemId=RedirectUrl.matchNo(redirectURL);
            StringBuilder sb = new StringBuilder();
            sb.append(DOU_YIN_BASE_URL).append(itemId);
            //获取返回的JSON
            String videoResult = RedirectUrl.httpGet(sb.toString());
            JSONObject t1=JSONUtil.parseObj(videoResult);
            JSONArray t2  =  t1.getJSONArray("item_list");
            JSONObject t3 =t2.getJSONObject(0);
            JSONObject t4= t3.getJSONObject("video");
            JSONObject t5=t4.getJSONObject("play_addr");
            String ss=t5.getJSONArray("url_list").getStr(0).replace("playwm", "play");

            map.put("url", ss);
        }
        return ResponseDataUtil.buildSuccess(map);
    }

    /**
     *  DOU_YIN_BASE_URL+itemId 返回的json数据
     {
     status_code: 0,
     item_list: [
     {
     music: {
     status: 1,
     id: 6886385382704680000,
     author: "🎵音乐先生兰天奇",
     cover_hd: {
     uri: "fd160004b2b491b3a57c",
     url_list: [
     "https://p29-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p9-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p26-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038"
     ]
     },
     cover_large: {
     uri: "fd160004b2b491b3a57c",
     url_list: [
     "https://p29-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p9-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p26-dy.byteimg.com/aweme/1080x1080/fd160004b2b491b3a57c.jpeg?from=4010531038"
     ]
     },
     cover_medium: {
     uri: "fd160004b2b491b3a57c",
     url_list: [
     "https://p3-dy-ipv6.byteimg.com/aweme/720x720/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p6-dy-ipv6.byteimg.com/aweme/720x720/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p1-dy-ipv6.byteimg.com/aweme/720x720/fd160004b2b491b3a57c.jpeg?from=4010531038"
     ]
     },
     cover_thumb: {
     uri: "fd160004b2b491b3a57c",
     url_list: [
     "https://p3-dy-ipv6.byteimg.com/aweme/100x100/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p9-dy.byteimg.com/aweme/100x100/fd160004b2b491b3a57c.jpeg?from=4010531038",
     "https://p29-dy.byteimg.com/aweme/100x100/fd160004b2b491b3a57c.jpeg?from=4010531038"
     ]
     },
     play_url: {
     url_list: [
     "https://p9-dy.byteimg.com/obj/ies-music/6886385387972561671.mp3",
     "https://p3-dy.byteimg.com/obj/ies-music/6886385387972561671.mp3"
     ],
     uri: "https://p9-dy.byteimg.com/obj/ies-music/6886385387972561671.mp3"
     },
     duration: 16,
     mid: "6886385382704679688",
     title: "@🎵音乐先生兰天奇创作的原声",
     position: null
     },
     risk_infos: {
     warn: false,
     type: 0,
     content: ""
     },
     forward_id: "0",
     video: {
     origin_cover: {
     uri: "tos-cn-p-0015/b7ebb8feac4e4aa79f2ece9e855c3027_1606658249",
     url_list: [
     "https://p6-dy-ipv6.byteimg.com/tos-cn-p-0015/b7ebb8feac4e4aa79f2ece9e855c3027_1606658249~tplv-dy-360p.jpeg?from=2563711402",
     "https://p9-dy.byteimg.com/tos-cn-p-0015/b7ebb8feac4e4aa79f2ece9e855c3027_1606658249~tplv-dy-360p.jpeg?from=2563711402",
     "https://p5-dy-ipv6.byteimg.com/tos-cn-p-0015/b7ebb8feac4e4aa79f2ece9e855c3027_1606658249~tplv-dy-360p.jpeg?from=2563711402"
     ]
     },
     duration: 8569,
     play_addr: {
     uri: "v0300f710000bv1qh7hc4uhi8qmv80f0",
     url_list: [
     "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0300f710000bv1qh7hc4uhi8qmv80f0&ratio=720p&line=0"
     ]
     },
     height: 720,
     width: 1280,
     has_watermark: true,
     bit_rate: null,
     vid: "v0300f710000bv1qh7hc4uhi8qmv80f0",
     cover: {
     uri: "tos-cn-p-0015/ae77704dac56466182190e22e733ae81",
     url_list: [
     "https://p29-dy.byteimg.com/img/tos-cn-p-0015/ae77704dac56466182190e22e733ae81~c5_300x400.jpeg?from=2563711402_large",
     "https://p26-dy.byteimg.com/img/tos-cn-p-0015/ae77704dac56466182190e22e733ae81~c5_300x400.jpeg?from=2563711402_large",
     "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/ae77704dac56466182190e22e733ae81~c5_300x400.jpeg?from=2563711402_large"
     ]
     },
     dynamic_cover: {
     uri: "tos-cn-p-0015/3fd2ff0ba4924ff1b932e81ec99880e2_1606658247",
     url_list: [
     "https://p9-dy.byteimg.com/obj/tos-cn-p-0015/3fd2ff0ba4924ff1b932e81ec99880e2_1606658247?from=2563711402_large",
     "https://p3-dy-ipv6.byteimg.com/obj/tos-cn-p-0015/3fd2ff0ba4924ff1b932e81ec99880e2_1606658247?from=2563711402_large",
     "https://p29-dy.byteimg.com/obj/tos-cn-p-0015/3fd2ff0ba4924ff1b932e81ec99880e2_1606658247?from=2563711402_large"
     ]
     },
     ratio: "540p"
     },
     share_info: {
     share_weibo_desc: "#在抖音，记录美好生活#原来动漫中的场景是真实存在的，这么罕见的一幕快艾特你家集美来看，别忘记许愿哦。#巨大流星深夜划过日本上空",
     share_desc: "在抖音，记录美好生活",
     share_title: "原来动漫中的场景是真实存在的，这么罕见的一幕快艾特你家集美来看，别忘记许愿哦。#巨大流星深夜划过日本上空"
     },
     image_infos: null,
     create_time: 1606658246,
     share_url: "https://www.iesdouyin.com/share/video/6900544602600721667/?region=&mid=6886385382704679688&u_code=48&titleType=title&did=0&iid=0",
     video_labels: null,
     group_id: 6900544602600721000,
     statistics: {
     aweme_id: "6900544602600721667",
     comment_count: 17880,
     digg_count: 115726,
     play_count: 0
     },
     text_extra: [
     {
     hashtag_id: 1684679610953742,
     start: 39,
     end: 52,
     type: 1,
     hashtag_name: "巨大流星深夜划过日本上空"
     }
     ],
     duration: 8569,
     video_text: null,
     promotions: null,
     is_preview: 0,
     desc: "原来动漫中的场景是真实存在的，这么罕见的一幕快艾特你家集美来看，别忘记许愿哦。#巨大流星深夜划过日本上空",
     author_user_id: 3949061942020414,
     geofencing: null,
     long_video: null,
     comment_list: null,
     aweme_id: "6900544602600721667",
     author: {
     avatar_larger: {
     uri: "tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5",
     url_list: [
     "https://p3-dy-ipv6-test.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_1080x1080.jpeg?from=4010531038",
     "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_1080x1080.jpeg?from=4010531038",
     "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_1080x1080.jpeg?from=4010531038"
     ]
     },
     platform_sync_info: null,
     policy_version: null,
     signature: "📷：干啥啥不行，宠粉第一名 🌈：热爱生活 爱好拍摄📸、、、 🌅：既来之则安之，你我皆为上上签 🌠：分享旅行，带你看满这个世界、 🔥：今天不知道又有哪个小可爱关注我",
     avatar_thumb: {
     uri: "tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5",
     url_list: [
     "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_100x100.jpeg?from=4010531038",
     "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_100x100.jpeg?from=4010531038",
     "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_100x100.jpeg?from=4010531038"
     ]
     },
     avatar_medium: {
     uri: "tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5",
     url_list: [
     "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_720x720.jpeg?from=4010531038",
     "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_720x720.jpeg?from=4010531038",
     "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7daf7a403c284554bfb8fd602c2998e5~c5_720x720.jpeg?from=4010531038"
     ]
     },
     unique_id: "xiaobizhi2580",
     followers_detail: null,
     uid: "3949061942020414",
     short_id: "3586853034",
     nickname: "Jessie 📸",
     geofencing: null,
     type_label: null
     },
     aweme_type: 4,
     label_top_text: null,
     is_live_replay: false,
     cha_list: [
     {
     hash_tag_profile: "",
     cid: "1684679610953742",
     cha_name: "巨大流星深夜划过日本上空",
     user_count: 0,
     type: 1,
     desc: "",
     connect_music: null,
     view_count: 0,
     is_commerce: false
     }
     ]
     }
     ],
     extra: {
     logid: "202011301759080101980621430302A870",
     now: 1606730348000
     }
     }
     */


}
