//package com.example.planIt.service;
//
//import com.example.YaRab.entity.User;
//import com.example.YaRab.repository.UserRepository;
//import com.example.planIt.util.JWTService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//    @Autowired
//    private JWTService jwtService;
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        //Get request header
//        String header = request.getHeader("Authorization");
//        if (header == null || !header.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        String jwt = header.substring(7);
//        //try {
//            String username = jwtService.extractUsername(jwt);
//            User user = userRepository.findByUsername(username).get();
//            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                    username, null, user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authToken);
//            filterChain.doFilter(request,response);
//        //}
////        catch (Exception e) {
////            // Handle signature verification failure
////            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////            response.getWriter().write("Invalid JWT Token");
////            return;
////        }
//    }}
////    String jwt = authHeader.split(" ")[1];
////    String username = jwtService.extractUsername(jwt);
////    User user = userRepository.findByUsername(username).get();
////
////    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
////            username, null, user.getAuthorities()
////    );
////
////        SecurityContextHolder.getContext().setAuthentication(authToken);
////
////        filterChain.doFilter(request, response);
////
////
////}