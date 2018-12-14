package com.antoszek.controller;

import com.antoszek.model.entityClass.Security;
import com.antoszek.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/security")
public class SecurityController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(SecurityController.class);
    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }




    @RequestMapping("/app/car/security/all_security")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Security> getSecurities(){
        List<Security> securities = securityService.findAll();
        log.info("Retrive objects {} ", securities);
        return securities;
    }


}
