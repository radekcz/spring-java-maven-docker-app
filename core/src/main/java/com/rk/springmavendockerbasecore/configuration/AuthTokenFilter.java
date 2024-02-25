package com.rk.springmavendockerbasecore.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final String authToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = request.getHeader(SecurityConfiguration.HEADER_X_AUTH_TOKEN);
        if (isValidToken(token)) {
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(new PreAuthenticatedAuthenticationToken(token, token, List.of()));
        }
        else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }

    private boolean isValidToken(String token) {
        return token != null && token.equals(authToken);
    }
}
