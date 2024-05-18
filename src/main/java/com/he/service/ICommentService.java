package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.AddCommentDto;
import com.he.domin.entity.mysql.Comment;

import java.util.ArrayList;

public interface ICommentService extends IService<Comment> {
    /**
     * 根据视频id获取顶层评论列表
     * @param videoId 视频id
     * @return 顶层评论列表
     */
    public ArrayList<Comment> getCommentListByVideoId(Integer videoId);

    /**
     * 根据用户id和视频id添加顶层评论
     * @param commentDto 添加评论的结构体
     * @return 执行结果
     */
    public Integer addComment(AddCommentDto commentDto);

    /**
     * 删除评论
     * @param commentId 评论id
     * @return 结果
     */
    public Integer deleteComment(Integer commentId);
}
