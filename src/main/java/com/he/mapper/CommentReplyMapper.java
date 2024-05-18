package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.CommentReply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentReplyMapper extends BaseMapper<CommentReply> {
}
