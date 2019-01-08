package com.antoszek.controller;

import com.antoszek.factoryMethod.FactoryInvoice;
import com.antoszek.model.Invoice;
import com.antoszek.model.RentalDTO;
import com.antoszek.model.Rentals;
import com.antoszek.model.entityClass.Car;
import com.antoszek.service.InvoiceService;
import com.antoszek.service.RentalService;
import com.antoszek.services.CarService;
import com.antoszek.services.ClientService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeDebug.map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/rental")
public class RentalController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(CarController.class);
    private final RentalService rentalService;
    private final CarService carService;
    private final ClientService clientService;
    private final InvoiceService invoiceService;

    @Autowired
    public RentalController(RentalService rentalService, CarService carService, ClientService clientService, InvoiceService invoiceService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.clientService = clientService;
        this.invoiceService = invoiceService;
    }

    @RequestMapping("/save_rental")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Rentals save(@RequestBody Rentals rentals) {
        Rentals rentalsSaved = rentalService.save(rentals);
        if (rentalsSaved == null)
            return null;
        log.info("Add new Rental[]", "Car ID: ", rentalsSaved.getCar_id(), "Client ID: ", rentalsSaved.getClient_id());
        return rentals;
    }

    @RequestMapping("/all_rental")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Rentals> getAllRentals() {
        List<Rentals> rentals = rentalService.findAll();
        log.info("Retrive objects {}", rentals);
        return rentals;
    }

    @RequestMapping("/find_byId/{id}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Rentals findById(@PathVariable Long id) {
        return rentalService.findById(id);
    }

    @RequestMapping("/all_rentals_by_user_id/{id}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Rentals> getRentalsByUserId(@PathVariable Long id) {
        return rentalService.getRentalsByClientId(id);
    }

    @RequestMapping("/all_rentals_by_car_id/{id}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Rentals> getRentalsByCarsId(@PathVariable Long id) {
        return rentalService.getRentalsByCarId(id);
    }

    @DeleteMapping("end_rental/{id}")
    public String deleteRental(@PathVariable Long id) {
        newInvoice(id);
        rentalService.endOffRental(id);
        return "Pomyślnie zwrócono samochód...";
    }

    public Invoice newInvoice(Long id) {
        FactoryInvoice factoryInvoice = new FactoryInvoice();
        Rentals r = rentalService.findById(id);
        Car c = carService.findById(r.getCar_id());
        double value = factoryInvoice.factoryCalculate(c.getCarClass(), r.getNumberOfDay());
        Invoice i = new Invoice();
        i.setCar_id(c.getId());
        i.setClient_id(r.getClient_id());
        i.setValue(value);
        i.setRental_id(r.getId());
        invoiceService.save(i);
        return i;
    }

    @RequestMapping("/edit")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Rentals update(@RequestBody Rentals rentals) {
        Rentals updatedRentals = rentalService.saveForUpdate(rentals);
        log.info("Updated Rental {}", updatedRentals);
        return updatedRentals;
    }

}