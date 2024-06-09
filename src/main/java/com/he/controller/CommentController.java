package com.he.controller;

import com.he.domin.dto.AddCommentDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mysql.Comment;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.ICommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Tag(name = "顶层评论接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private ICommentService commentService;
    @GetMapping("/getCommentListByVideoId")
    @Operation(summary = "getCommentListByVideoId", description = "根据视频id获取其底下的每个顶层评论")
    public ResponseResult getCommentListByVideoId( @RequestParam("videoId") Integer videoId){
        ArrayList<Comment> commentList = commentService.getCommentListByVideoId(videoId);
        return ResponseResult.okResult(commentList);
    }

    @PutMapping("/addComment")
    @Operation(summary = "addComment", description = "添加顶层评论信息，像点赞数，创建时间等也有默认值")
    private ResponseResult addComment(@RequestBody AddCommentDto addCommentDto){
        Integer result = commentService.addComment(addCommentDto);
        if (result!=0)return ResponseResult.okResult(200,"添加评论成功");
        return ResponseResult.errorResult(500,"添加评论失败");
    }

    @DeleteMapping("/deleteComment")
    @Operation(summary = "deleteComment", description = "删除评论")
    private ResponseResult deleteComment(@RequestParam("commentId") Integer commentId){
        Integer result = commentService.deleteComment(commentId);
        if (result!=0) return ResponseResult.okResult(200,"删除评论成功！！");
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"可能数据不存在？");
    }

}
