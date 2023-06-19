package com.blogapp.Blogging.util;


//import com.app.blog.models.Users;
import com.blogapp.Blogging.models.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * @author 1460344
 */
@Component
public class JWTUtils {

    public String CreateJWTToken(Users user) {

        Claims claims= Jwts.claims();
        claims.put("name", user.getUserName());
        claims.put("email", user.getEmail());
        claims.put("user_id", user.getUserId());
        claims.setSubject("MY Blog");
        claims.setIssuedAt(new Date());

        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SECRET)
                .compact();

        return token;
    }
}
