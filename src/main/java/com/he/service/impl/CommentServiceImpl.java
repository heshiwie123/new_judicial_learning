package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.AddCommentDto;
import com.he.domin.entity.mysql.Comment;
import com.he.domin.entity.mysql.User;
import com.he.mapper.CommentMapper;
import com.he.mapper.UserMapper;
import com.he.service.ICommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Slf4j
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public ArrayList<Comment> getCommentListByVideoId(Integer videoId) {

        log.info("CommentServiceImpl=====>getCommentListByVideoId------>"
                +"videoId:"+videoId);
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getVideoId,videoId);
        //查询
        return (ArrayList<Comment>) commentMapper.selectList(queryWrapper);
    }


    @Override
    public Integer addComment(AddCommentDto commentDto) {
        log.info("CommentServiceImpl=====>addCommentByUserIdAndVideoId------>"
                +"videoId:"+commentDto.getVideoId()
                +"userId:"+commentDto.getUserId()
                +"content:"+commentDto.getContent());
        //根据用户id查找用户信息
        User user = userMapper.selectUserByUserId(commentDto.getUserId());

        //构建评论信息
        Comment comment = new Comment();
        comment.setUserId(commentDto.getUserId())
                .setVideoId(commentDto.getVideoId())
                .setContent(commentDto.getContent())
                .setUserName(user.getUsername())
                .setCreatedTime(LocalDateTime.now())
                .setProfilePhoto(user.getProfilePhoto())
                .setSumLike(0)
                .setSumReply(0);
        return commentMapper.insert(comment);
    }

    @Override
    public Integer deleteComment(Integer commentId) {
        log.info("CommentServiceImpl=====>deleteComment------>"+"要删除的评论id"+commentId);

        LambdaUpdateWrapper<Comment> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Comment::getId,commentId);
        return commentMapper.delete(updateWrapper);

    }
}
