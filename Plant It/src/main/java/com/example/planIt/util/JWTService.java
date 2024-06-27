//package com.example.planIt.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.Map;
//
//@Service
//public class JWTService {
////    Date issuedAt=new Date(System.currentTimeMillis());
////    Date expiration=new Date(issuedAt.getTime()+(30*60*1000));
//    private final String secretKey="VGhpcyBpcyBteSBzZWNyZXQga2V5IHRoYXQgeW91IGNhbiBub3QgaGFjaw==";
////    public String generateToken(User user, Map<String,Object> extraClaims){
////        Date issuedAt=new Date(System.currentTimeMillis());
////        Date expiration=new Date(issuedAt.getTime()+(30*60*1000));
////       return Jwts.builder()
////                .setClaims(extraClaims)
////                .setSubject(user.getUsername())
////                .setIssuedAt(issuedAt)
////                .setExpiration(expiration)
////                .signWith(generateKey(), SignatureAlgorithm.HS256)
////                .compact();
////    }
////    public Key generateKey(){
////        byte[] secretBytes= Decoders.BASE64.decode(secretKey);
////      return Keys.hmacShaKeyFor(secretBytes);
////    }
////    public String extractUsername(String jwt){
////        return extractAllClaims(jwt).getSubject();
////
////        //Jwts.parserBuilder().setSigningKey
////    }
////    public Claims extractAllClaims(String jwt){
////        return Jwts.parser().setSigningKey(generateKey()).build()
////                .parseClaimsJws(jwt).getBody();
////                //.parseEncryptedClaims(jwt).getPayload();
////    }
//}
