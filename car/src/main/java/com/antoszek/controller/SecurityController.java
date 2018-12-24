package com.antoszek.controller;

import com.antoszek.model.ModelDTO.SecurityDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.model.entityClass.Security;
import com.antoszek.services.CarService;
import com.antoszek.services.SecurityService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/security")
public class SecurityController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(SecurityController.class);
    private final SecurityService securityService;
    private final CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public SecurityController(SecurityService securityService, CarService carService) {
        this.securityService = securityService;
        this.carService = carService;
    }


    @RequestMapping("/all_security")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Security> getSecurities(){
        List<Security> securities = securityService.findAll();
        log.info("Retrive objects {} ", securities);
        return securities;
    }

    @RequestMapping(value = "/add_security_to_car", method = RequestMethod.POST)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Security saveSecurityToCar(@RequestBody SecurityDTO securityDTO){
        Security savedSecurity = modelMapper.map(securityDTO, Security.class);
        Car car = carService.findById(securityDTO.getCar_id());
        savedSecurity.setCar(car);
        securityService.save(savedSecurity);
        return savedSecurity;
    }
    @RequestMapping("/edit/{id}")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Security update(@PathVariable Long id, @RequestBody SecurityDTO securityDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Security updateSecurity = securityService.findById(id);
        modelMapper.map(securityDTO,updateSecurity);
        securityService.update(updateSecurity);
        log.info("Update car Car[]", updateSecurity.isAbsSystem());
        return updateSecurity;

    }

    @RequestMapping("/find_byId/{id}")
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public Security getSecurityById(@PathVariable Long id) {
        return securityService.findById(id);
    }

    @DeleteMapping("/delete_security/{id}")
    public String deleteSecurity(@PathVariable Long id) {
        securityService.deleteSecurity(id);
        return "Pomyślnie usunięto czujniki parkowania z samochodu";
    }


}
