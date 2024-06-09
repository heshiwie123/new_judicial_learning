package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    Menu selectMenuByURI(@Param("uri") String uri);
}
