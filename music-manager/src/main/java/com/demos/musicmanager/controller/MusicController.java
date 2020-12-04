package com.demos.musicmanager.controller;

import com.demos.musicmanager.pojo.bo.MusicBO;
import com.demos.musicmanager.pojo.entity.Music;
import com.demos.musicmanager.util.response.ResponseData;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.demos.musicmanager.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/addMusic")
    public ResponseData addMusic(MusicBO musicBO) throws  Exception{
        return musicService.addMusic(musicBO);
    }


}