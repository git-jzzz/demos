package com.demos.begindemo.util.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: jz
 * @Date: 2020/11/30 14:07
 * @Description: URL处理
 */
public class RedirectUrl {
    public static String getLocation(String url) throws  Exception{
        URL serverUrl=new URL(url);
        HttpURLConnection connection=(HttpURLConnection)serverUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(false);
        connection.setRequestProperty("User-agent","ua");    //模拟手机
        connection.connect();
        String location=connection.getHeaderField("Location");
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


    public static String httpGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/json;charset=utf-8");
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


}
