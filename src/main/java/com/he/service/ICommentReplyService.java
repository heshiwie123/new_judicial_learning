package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.AddCommentReplyDto;
import com.he.domin.entity.mysql.CommentReply;

import java.util.ArrayList;

public interface ICommentReplyService extends IService<CommentReply> {
    /**
     * 根据顶层评论的id获取评论的回复
     * @param commentId 评论id
     * @return 评论的回复列表
     */
    public ArrayList<CommentReply> getCommentReplyByCommentId(Integer commentId);

    /**
     * 根据用户id,顶层评论的id
     * 添加一条回复replyUserId的评论
     * @param commentReplyDto 回复评论的评论dto
     * @return 执行结果
     */
    public Integer addComment(AddCommentReplyDto commentReplyDto);

    /**
     * 根据评论回复的id 删除评论
     * @param commentReplyId 评论回复的id
     * @return 结果
     */
    public Integer deleteComment(Integer commentReplyId);
}
