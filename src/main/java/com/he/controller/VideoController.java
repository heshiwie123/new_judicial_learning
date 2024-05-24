package com.he.controller;

import com.he.domin.dto.ResponseResult;
import com.he.service.IVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/video")
@Tag(name = "视频接口")
public class VideoController {
    @Resource
    private IVideoService videoService;

    @GetMapping("/getVideoListByScreen")
    @Operation(summary = "getVideoListByScreen" ,description = "根据筛选得条件获取视频列表")
    public ResponseResult getVideoListByScreen(){
        return null;
    }
    @PutMapping("/updateVideoByVideoId")
    @Operation(summary = "updateVideoByVideoId" ,description = "根据视频id,更新视频信息，观看量，点赞量等")
    public ResponseResult updateVideoByVideoId(){
        return null;
    }
}
