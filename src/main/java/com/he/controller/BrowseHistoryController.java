package com.he.controller;

import com.he.domin.dto.BrowseHistoryUpdateRequestDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mysql.BrowseHistory;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IBrowseHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@Tag(name = "浏览记录接口")
@RestController
@RequestMapping("/browseHistory")
public class BrowseHistoryController {
    @Resource
    private IBrowseHistoryService browseHistoryService;

    @GetMapping("/getBrowseHistory/")
    @Operation(summary = "getBrowseHistory", description = "根据视频id和用户id获取浏览记录，以便实现“继续观看”")
    public ResponseResult getBrowseHistory(@RequestParam("userId") int userId, @RequestParam("videoId") int videoId) {
        BrowseHistory browseHistory = browseHistoryService.getBrowseHistoryByUserIdAndVideoId(userId, videoId);
        HashMap<String, BrowseHistory> resultMap = new HashMap<>();
        resultMap.put("browseHistory",browseHistory);
        return ResponseResult.okResult(resultMap);
    }
    @PostMapping("/updateBrowseHistory")
    @Operation(summary = "updateBrowseHistory", description = "更新浏览记录信息，主要就是观看时长，是否点赞等”")
    public ResponseResult updateBrowseHistory(@RequestBody BrowseHistoryUpdateRequestDto browseHistoryDto) {
        Integer result = browseHistoryService.updateBrowseHistoryByBrowseHistoryId(browseHistoryDto);
        return ResponseResult.okResult(result);
    }
    @PutMapping("/addBrowseHistory")
    @Operation(summary = "addBrowseHistory", description = "新增浏览记录，这里像是点赞，创建时间等都有默认值，可不传”")
    public ResponseResult addBrowseHistory(@RequestBody BrowseHistory browseHistory){
        Integer result = browseHistoryService.addBrowseHistory(browseHistory);
        if (result!=0) return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode(),"浏览记录保存成功！");
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"操作失败！,也许已经存在！");
    }
}
