package com.he.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;


public class JwtUtils {
    //密钥
    private static final String secret="dasadfjksfgsegfgsjdafzhiheyunqi";

    // 私有构造方法，防止实例化
    private JwtUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    /**
     * 生成token
     */
    public static String createToken(Map<String, Object> map){
        return Jwts.builder()
                //输入信息
                .setClaims(map)
                //颁发时间
                .setIssuedAt(new Date())
                //过期时间(2.5小时)
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 *3600* 150))
                //加密算法
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    /**
     * token解析用户信息
     */
    public static Claims parseToken(String token){
        //使用相同密钥
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
