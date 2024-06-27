//package com.example.planIt.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//
//public class TokenService {
//
//    private static final String SECRET_KEY = "VGhpcyBpcyBteSBzZWNyZXQga2V5IHRoYXQgeW91IGNhbiBub3QgaGFjaw==";
//
//    public static String generateToken(String userId, String role) {
//        return Jwts.builder()
//                .setSubject(userId)
//                .claim("role", role)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public static Claims decodeJWT(String jwt) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
//    }
//
//    public static boolean isTourist(HttpServletRequest request) {
//        String jwt = request.getHeader("Authorization");
//        if (jwt != null && jwt.startsWith("Bearer ")) {
//            jwt = jwt.substring(7);
//            Claims claims = decodeJWT(jwt);
//            String role = (String) claims.get("role");
//            return role.equals("tourist");
//        }
//        return false;
//    }
//}
