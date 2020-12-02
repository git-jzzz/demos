package com.demos.begindemo.controller;

import com.demos.begindemo.service.RemoveWMService;
import com.demos.begindemo.util.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jz
 * @Date: 2020/11/30 13:50
 * @Description:  去抖音视频水印
 */
@RestController
@RequestMapping("/removeWM")
public class RemoveWMController {

    @Autowired
    private RemoveWMService removeWMService;

    @GetMapping("/getVideo")
    public ResponseData getVideo(@RequestParam("url") String url) throws Exception{
       /* String i=null;
        System.out.println(i.toLowerCase());*/
        return removeWMService.rmwm(url);
    }
}
