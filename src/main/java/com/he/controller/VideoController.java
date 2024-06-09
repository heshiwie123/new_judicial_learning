package com.he.controller;

import com.he.domin.dto.PageResponse;
import com.he.domin.dto.ResponseResult;
import com.he.domin.dto.VideoRequestDto;
import com.he.domin.dto.VideoUpdateRequestDto;
import com.he.domin.entity.mysql.Video;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/video")
@Tag(name = "视频接口")
public class VideoController {
    @Resource
    private IVideoService videoService;

    @PostMapping("/getVideoListByScreen")
    @Operation(summary = "getVideoListByScreen", description = "根据筛选得条件获取视频列表")
    public ResponseResult getVideoListByScreen(@RequestBody VideoRequestDto videoRequestDto) {
        PageResponse<Video> videoList = videoService.getVideoListByScreen(videoRequestDto);
        //构建data
        HashMap<String, PageResponse<Video>> resultMap = new HashMap<>();
        resultMap.put("videoList", videoList);
        return new ResponseResult(200, "视频数据获取成功", resultMap);
    }

    @PostMapping("/updateVideoByVideoId")
    @Operation(summary = "updateVideoByVideoId", description = "根据视频id,更新视频信息，观看量，点赞量等更新视频数据")
    public ResponseResult updateVideoByVideoId(@RequestBody  VideoUpdateRequestDto videoUpdateRequestDto) {
        int updatedNum = videoService.updateVideoByVideoId(videoUpdateRequestDto);
        HashMap<String, Integer> resultMap = new HashMap<>();
        resultMap.put("updatedNum", updatedNum);
        if (updatedNum != 0) {
            return ResponseResult.okResult(resultMap);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED, "没有更新任何数据");
    }
}
