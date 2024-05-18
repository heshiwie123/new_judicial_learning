package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.AddCommentReplyDto;
import com.he.domin.entity.mysql.Comment;
import com.he.domin.entity.mysql.CommentReply;
import com.he.domin.entity.mysql.User;
import com.he.mapper.CommentReplyMapper;
import com.he.mapper.UserMapper;
import com.he.service.ICommentReplyService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Slf4j
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyMapper, CommentReply>  implements ICommentReplyService {
    @Resource
    private CommentReplyMapper commentReplyMapper;
    @Resource
    private UserMapper  userMapper;
    @Resource
    private LambdaQueryWrapper<CommentReply> lambdaQueryWrapper;
    @Resource
    private LambdaUpdateWrapper<CommentReply> lambdaUpdateWrapper;

    @Override
    public ArrayList<CommentReply> getCommentReplyByVideoIdAndCommentId(Integer commentId) {
        log.info("CommentReplyServiceImpl===>getCommentReplyByVideoIdAndCommentId"
                +"commentId:"+commentId);

        lambdaQueryWrapper.eq(CommentReply::getCommentId,commentId);

        //查询
        ArrayList<CommentReply> commentReplies = (ArrayList<CommentReply>) commentReplyMapper.selectList(lambdaQueryWrapper);


        return commentReplies;
    }

    @Override
    public Integer addCommentByUserIdAndVideoId(AddCommentReplyDto commentReplyDto) {
        log.info("CommentReplyServiceImpl===>addCommentByUserIdAndVideoId"
                +"replyUserId:"+commentReplyDto.getReplyUserId()
                +"userId:"+commentReplyDto.getUserId()
                +"commentId:"+commentReplyDto.getCommentId()
                +"content:"+commentReplyDto.getContent());
        //获取回复用户的信息
        User replyUser = userMapper.selectById(commentReplyDto.getReplyUserId());

        //获取自身用户的信息
        User selfUser = userMapper.selectById(commentReplyDto.getUserId());
        CommentReply commentReply = new CommentReply();

        //评论信息构建
        commentReply.setUserId(commentReplyDto.getUserId())
                .setCommentId(commentReplyDto.getCommentId())
                .setContent(commentReplyDto.getContent())
                .setUserName(selfUser.getUsername())
                .setCreatedTime(LocalDateTime.now())
                .setProfilePhoto(selfUser.getProfilePhoto())
                .setSumLike(0)
                .setIsDeleted(0)
                .setReplyUserId(commentReplyDto.getReplyUserId())
                .setReplyUserName(replyUser.getUsername());
        int result = commentReplyMapper.insert(commentReply);
        return result;
    }
    @Override
    public Integer deleteComment(Integer commentReplyId) {
        log.info("CommentReplyServiceImpl=====>deleteComment------>"+"要删除的评论id"+commentReplyId);

        lambdaUpdateWrapper.eq(CommentReply::getId,commentReplyId);
        lambdaUpdateWrapper.set(CommentReply::getIsDeleted,1);

        int result = commentReplyMapper.update(null, lambdaUpdateWrapper);
        //清除
        lambdaUpdateWrapper.clear();
        return result;
    }
}
