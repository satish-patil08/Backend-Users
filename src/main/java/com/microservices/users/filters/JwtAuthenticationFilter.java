package com.microservices.users.filters;

import com.microservices.shared_utils.jwtUtils.CustomUserDetails;
import com.microservices.shared_utils.jwtUtils.JwtUtils;
import com.microservices.users.logic.users.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
/*
        if (path.equals("/users/login") || path.equals("/users/register")) {
            filterChain.doFilter(request, response);
            return;
        }
*/

        String token = "";
        String header = request.getHeader("Authorization");
        token = (header != null && header.startsWith("Bearer ")) ? header.substring(7) : null;

        if (token != null) {
            try {
                String username = jwtUtils.extractUsername(token);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                    if (jwtUtils.validateToken(token, new CustomUserDetails(userDetails.getUsername(), userDetails.getPassword()))) {
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            } catch (Exception e) {
                response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Unauthorized: Invalid token"
                );
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /*@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.equals("/users/login") || path.equals("/users/register");
    }*/

}