package com.he.web;

import com.he.domin.entity.mysql.Identity;
import com.he.domin.entity.mysql.Menu;
import com.he.domin.entity.mysql.User;
import com.he.mapper.IdentityMapper;
import com.he.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private IdentityMapper identityMapper;

    /**
     * 重写loadUserByUsername方法，这里主要是为了查找用户时，将身份，权限信息等一并查出
     * @param username 用户名
     * @return 包含权限信息，身份信息的用户User
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername========>,要登陆的用户用户名：{}", username);

        // 获取用户与其身份
        //根据用户名获取用户
        User user=userMapper.selectUserByUsername(username);
        log.info("登录的用户信息========》{}",user);

        //查询用户的权限信息
        if(user!=null){
            //身份
            Set<Identity> identitySet =user.getIdentitySet();
            //存储身份信息，批量查询而不是重复查询数据库
            Set<Integer> identityIds= identitySet.stream().map(Identity::getId).collect(Collectors.toSet());

            log.info("登录的用户身份id列表============》{}",identityIds);
            //将身份id集合用于查询权限
            Set<Menu> menus=identityMapper.selectMenuByIdentityIdS(identityIds);

            log.info("登录的用户的权限================》{}",menus);
            Set<String> strings = menus.stream().map(Menu::getPerms).collect(Collectors.toSet());
            //存入user的Menus中
            user.setMenuSet(strings);
        }
        return user;
    }
}
