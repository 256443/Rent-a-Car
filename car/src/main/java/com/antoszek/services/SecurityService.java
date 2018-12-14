package com.antoszek.services;

import com.antoszek.model.entityClass.Security;
import com.antoszek.repository.SecurityRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {


    private final SecurityRepository securityRepository;
    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }
    public Security save(Security security){
        Security savedSecurity = securityRepository.save(security);
        return savedSecurity;
    }
    public List<Security> findAll(){
        Iterable<Security> securityIterable = securityRepository.findAll();
        List<Security> securities = Lists.newArrayList(securityIterable);
        return securities;
    }
}
