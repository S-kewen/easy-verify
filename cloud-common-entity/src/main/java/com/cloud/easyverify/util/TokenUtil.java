package com.cloud.easyverify.util;

import cn.hutool.crypto.SecureUtil;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.util
 * @ClassName: TokenUtil
 * @Description: This is TokenUtil class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 20:22
 */
@Component
public class TokenUtil {
    @Value("${jwt.config.salt}")
    private String salt;
    @Value("${jwt.config.ttl}")
    private long ttl;

    public String createToken(User user) {
        JwtBuilder JwtBuilder = Jwts.builder()
                .setId(String.valueOf(user.getId()))
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .claim("role", user.getType() == 2 ? "admin" : "user")
                .claim("cipher", SecureUtil.md5(user.getPassword()))
                .signWith(SignatureAlgorithm.HS256, salt);
        return JwtBuilder.compact();
    }

    public Token parseToken(String tokenStr) {
        Claims claims = Jwts.parser()
                .setSigningKey(salt)
                .parseClaimsJws(tokenStr)
                .getBody();
        User user = new User();
        user.setId(Long.parseLong(claims.getId()));
        Token token = new Token();
        token.setId(Long.parseLong(claims.getId()));
        token.setUsername(claims.getSubject());
        token.setPassword((String) claims.get("cipher"));
        token.setRole((String) claims.get("role"));
        token.setAddTime(claims.getIssuedAt());
        token.setExpireTime(claims.getExpiration());
        return token;
    }
}
