package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.Identity;
import com.he.domin.entity.mysql.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;
@Mapper
public interface IdentityMapper extends BaseMapper<Identity> {
    Set<Menu> selectMenuByIdentityIdS(@Param("Ids") Set<Integer> setId);

    Integer selectIdentityIdByName(@Param("identityName") String identityName);
}
