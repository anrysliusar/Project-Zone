package com.sliusar.projectzone.security.config;

import io.jsonwebtoken.*;
import lombok.Value;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

//@Component
//@Log
//public class JwtProvider {
//
//    //@Value("$(jwt.secret)") FIX
//    private String jwtSecret;
//
//    public String generateToken(String login) {
//        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
//        return Jwts.builder()
//                .setSubject(login)
//                .setExpiration(date)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            return true;
//        } catch (ExpiredJwtException expEx) {
//            log.severe("Token expired");
//        } catch (UnsupportedJwtException unsEx) {
//            log.severe("Unsupported jwt");
//        } catch (MalformedJwtException mjEx) {
//            log.severe("Malformed jwt");
//        } catch (SignatureException sEx) {
//            log.severe("Invalid signature");
//        } catch (Exception e) {
//            log.severe("invalid token");
//        }
//        return false;
//    }
//
//    public String getLoginFromToken(String token) {
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//        return claims.getSubject();
//    }
//}
