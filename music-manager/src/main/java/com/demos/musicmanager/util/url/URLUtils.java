package com.demos.musicmanager.util.url;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: jz
 * @Date: 2020/11/30 14:07
 * @Description: URL处理工具类
 */
@Slf4j
public class URLUtils {
    public static String getLocation(String url) throws Exception {
        URL serverUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(false);
//        connection.setRequestProperty("User-agent","ua");    //模拟手机
        connection.connect();
        String location = connection.getHeaderField("Location");
        return location;
    }


    public static String matchNo(String redirectUrl) {
        List<String> results = new ArrayList<>();
        Pattern p = Pattern.compile("video/([\\w/\\.]*)/");
        Matcher m = p.matcher(redirectUrl);
        while (!m.hitEnd() && m.find()) {
            results.add(m.group(1));
        }
        return results.get(0);
    }


    /**
     * get获取返回的文本
     *
     * @param urlStr
     * @return
     * @throws Exception
     */
    public static String httpGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        //带上咪咕音乐网站
        conn.setRequestProperty("Referer", "https://music.migu.cn/v3/music/player/audio");
        //模拟浏览器
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
        conn.setRequestProperty("Accept", "*/*");
        int code = conn.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuffer buf = new StringBuffer();
        String inputLine = in.readLine();
        while (inputLine != null) {
            buf.append(inputLine).append("\r\n");
            inputLine = in.readLine();
        }
        in.close();
        return buf.toString();
    }


    /**
     * url获取数据的输入流
     *
     * @param strUrl
     * @return
     */
    public static InputStream getInputStreamByUrl(String strUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //模拟浏览器
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
            conn.setRequestProperty("Accept", "*/*");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), output);
            return new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            log.error(e + "");
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                log.error(e + "");
            }
        }
        return null;
    }


    /**
     * 字符串转换为输入流
     * @param sInputString
     * @return
     */
    public static InputStream getStreamByString(String sInputString) {
        if (!StrUtil.isEmpty(sInputString)) {
            ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
            return tInputStringStream;
        }
        return null;
    }


    /**
     * 输入流转换为字符串
     * @param tInputStream
     * @return
     */
    public static String getStringByStream(InputStream tInputStream) {
        if (tInputStream != null) {
            try {
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuffer tStringBuffer = new StringBuffer();
                String sTempOneLine = new String("");
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
