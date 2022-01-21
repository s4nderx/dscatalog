package com.devsuperior.dscatalog.services;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class TokenService {

    @Resource(name="tokenServices")
    private ConsumerTokenServices tokenServices;

    public void revokeToken(HttpServletRequest request) {
        this.tokenServices.revokeToken(this.getTokenFromHeader(request));
    }

    public String getTokenFromHeader(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")){
            return authorization.substring("Bearer".length()+1);
        }
        return authorization;
    }

}
