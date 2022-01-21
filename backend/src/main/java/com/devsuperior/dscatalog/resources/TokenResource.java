package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/oauth")
public class TokenResource {

    @Autowired
    TokenService service;

    @PostMapping( "/logout")
    public ResponseEntity<Void> revokeToken(HttpServletRequest request) {
        this.service.revokeToken(request);
        return  ResponseEntity.noContent().build();
    }

}
