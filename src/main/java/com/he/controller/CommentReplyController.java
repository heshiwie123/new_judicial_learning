package com.he.controller;

import com.he.domin.dto.AddCommentReplyDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mysql.CommentReply;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.ICommentReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Tag(name = "次层评论接口")
@RestController
@RequestMapping("/commentReply")
public class CommentReplyController {
    @Resource
    private ICommentReplyService commentReplyService;

    @GetMapping("/getCommentReplyByCommentId")
    @Operation(summary = "getCommentReplyByCommentId", description = "根据顶层评论的id获取其低下评论")
    private ResponseResult getCommentReplyByCommentId(@RequestParam("commentId") Integer commentId){
        ArrayList<CommentReply> commentList= commentReplyService.getCommentReplyByCommentId(commentId);

        return ResponseResult.okResult(commentList);
    }

    @PutMapping("/addCommentReply")
    @Operation(summary = "addCommentReply", description = "添加评论回复，这里相关图片和用户名不需要传入，后端会查数据库补充")
    private ResponseResult addCommentReply(@RequestBody AddCommentReplyDto commentReplyDto){
        Integer result = commentReplyService.addComment(commentReplyDto);
        if (result!=0)return ResponseResult.okResult(200,"添加回复成功！");
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"回复失败");
    }


    @DeleteMapping("/deleteCommentReply")
    @Operation(summary = "deleteCommentReply", description = "删除评论回复")
    private ResponseResult deleteCommentReply(@RequestParam("commentReplyId") Integer commentReplyId){
        Integer result = commentReplyService.deleteComment(commentReplyId);
        if (result!=0)return ResponseResult.okResult(200,"删除成功！");
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"删除失败");
    }
}
