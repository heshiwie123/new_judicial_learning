package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     */
    User selectUserByUsername(@Param("name") String name);

    /**
     * 用户获得身份
     * @param userId 用户对应id
     * @param identityId 身份id
     * @return 执行结果
     */
    Boolean addUserIdentity(@Param("userId") Integer userId, @Param("identityId") Integer identityId);

    /**
     * 根据id查找用户
     * @param userId id
     * @return user
     */
    User selectUserByUserId(@Param("userId") Integer userId);
}
