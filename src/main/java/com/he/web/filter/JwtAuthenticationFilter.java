package com.he.web.filter;

import com.he.domin.entity.mysql.Identity;
import com.he.domin.entity.mysql.User;
import com.he.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("Authorization");
        //没有token可能是login，直接放行（此后由其他过滤器处理）
        if (token == null) {
            doFilter(request, response, filterChain);
            return;
        }

        //有token,Jwt解析数据
        log.info("token=============>{}", token);
        Claims claims = null;
        try {
            claims = JwtUtils.parseToken(token);
            // 获取过期时间
            Date expiration = claims.getExpiration();
            // 获取当前时间
            Date now = new Date();

            // 判断是否过期
            if (now.after(expiration)) {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Token 已过期，请重新登录！！！！");
                return;
            }

        } catch (SignatureException e) {
            //验签出错会导致乱码，设置格式
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("验签失败，请重新登录！！！！");
            return;
        }
        //获取到信息
        Integer id = claims.get("用户Id",Integer.class);
        String name=claims.get("用户Name", String.class);
        ArrayList<Identity> identityList =claims.get("用户身份", ArrayList.class);
        ArrayList<String> menuList=claims.get("用户权限", ArrayList.class);
        log.info("用户身份：=================》{}",identityList);
        log.info("权限：=================》{}",menuList);

        /**
         * jwt解析完数据会将数据转换为ArrayList类型，不匹配我们的Set
         * 设置新的Set集合，将刚刚jwt解释的ArrayList类型数据添加进去，在添加到用户
         */
        // 使用Stream API将ArrayList转换为Set并设置到User对象中
        Set<Identity> identitySet = new HashSet<>(identityList);
        Set<String> menuSet = new HashSet<>(menuList);
        //放到user中
        User user=new User();
        user.setId(id);
        user.setUsername(name);
        user.setIdentitySet(identitySet);
        user.setMenuSet(menuSet);

        //用户信息放置到SecurityContext中
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        doFilter(request,response,filterChain);
    }
}
