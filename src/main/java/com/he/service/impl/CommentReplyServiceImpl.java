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
    private LambdaUpdateWrapper<CommentReply> lambdaUpdateWrapper;

    @Override
    public ArrayList<CommentReply> getCommentReplyByCommentId(Integer commentId) {
        log.info("CommentReplyServiceImpl===>getCommentReplyByVideoIdAndCommentId"
                +"commentId:"+commentId);
        LambdaQueryWrapper<CommentReply> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CommentReply::getCommentId,commentId);
//        lambdaQueryWrapper.eq(CommentReply::getIsDeleted,0);

        //查询
        return (ArrayList<CommentReply>) commentReplyMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public Integer addComment(AddCommentReplyDto commentReplyDto) {
        log.info("CommentReplyServiceImpl===>addCommentByUserIdAndVideoId"
                +"replyUserId:"+commentReplyDto.getReplyUserId()
                +"userId:"+commentReplyDto.getUserId()
                +"commentId:"+commentReplyDto.getCommentId()
                +"content:"+commentReplyDto.getContent());
        User replyUser = new User();
        //获取回复用户的信息
        if (commentReplyDto.getReplyUserId()!=null){
            replyUser = userMapper.selectUserByUserId(commentReplyDto.getReplyUserId());
        }


        //获取自身用户的信息
        User selfUser = userMapper.selectUserByUserId(commentReplyDto.getUserId());
        CommentReply commentReply = new CommentReply();

        //评论信息构建
        commentReply.setUserId(commentReplyDto.getUserId())
                .setCommentId(commentReplyDto.getCommentId())
                .setContent(commentReplyDto.getContent())
                .setUserName(selfUser.getUsername())
                .setCreatedTime(LocalDateTime.now())
                .setProfilePhoto(selfUser.getProfilePhoto())
                .setSumLike(0)
                .setReplyUserId(commentReplyDto.getReplyUserId())
                .setReplyUserName(replyUser.getUsername());
        return commentReplyMapper.insert(commentReply);

    }
    @Override
    public Integer deleteComment(Integer commentReplyId) {
        log.info("CommentReplyServiceImpl=====>deleteComment------>"+"要删除的评论id"+commentReplyId);
        LambdaUpdateWrapper<CommentReply> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(CommentReply::getId,commentReplyId);
        return commentReplyMapper.delete( lambdaUpdateWrapper);
    }
}
