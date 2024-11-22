package com.liugaorong.blog.common.utils;

import com.liugaorong.blog.common.exception.BlogException;
import com.liugaorong.blog.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
  
  private static SecretKey secretKey = Keys.hmacShaKeyFor("CY29Eb04RPNyQPxACH2jBNWFGn0ypMhc".getBytes());
  
  public static String createToken(Long userId, String username) {
    
    return Jwts.builder()
      .setSubject("LOGIN_USER")
      .setExpiration(new Date(System.currentTimeMillis() + 3600000))
      .claim("userId", userId)
      .claim("username", username)
      .signWith(secretKey, SignatureAlgorithm.HS256)
      .compact();
  }
  
  public static Claims parseToken(String token) {
    
    if (token == null) {
      throw new BlogException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
    }
    
    try {
      Jws<Claims> claimsJws = Jwts.parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(token);
      return claimsJws.getBody();
    } catch (ExpiredJwtException e) {
      throw new BlogException(ResultCodeEnum.TOKEN_EXPIRED);
    } catch (JwtException e) {
      throw new BlogException(ResultCodeEnum.TOKEN_INVALID);
    }
  }
  
  
  public static void main(String[] args) {
    System.out.println(createToken(1L, "admin"));
  }
}
