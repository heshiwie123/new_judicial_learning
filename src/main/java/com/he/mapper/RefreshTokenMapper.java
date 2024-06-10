package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.RefreshToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RefreshTokenMapper extends BaseMapper<RefreshToken> {
}
