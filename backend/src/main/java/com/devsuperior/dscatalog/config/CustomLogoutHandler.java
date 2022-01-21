package com.devsuperior.dscatalog.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            request.logout();
            String authValue = request.getHeader("authorization");
            System.out.println(authValue);
        } catch (ServletException e) {
            System.out.println("SEI LA MANO");
        }
    }



}
