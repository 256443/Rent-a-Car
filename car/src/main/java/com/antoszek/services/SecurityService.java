package com.antoszek.services;

import com.antoszek.model.entityClass.Security;
import com.antoszek.repository.SecurityRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Security findById(Long id) {
        Optional<Security> security = securityRepository.findById(id);
        if (security.isPresent()) {
            return security.get();
        }
        return null;
    }

    public Security update(Security security) {
        if(securityRepository.existsById(security.getId())){
            return securityRepository.save(security);
        }
        else{
            return null;      }
    }
    public String deleteSecurity(Long id){
        securityRepository.deleteById(id);
        return "Pomyslnie usunieto systemy bezpieczeństawa z bazy";

    }
}
