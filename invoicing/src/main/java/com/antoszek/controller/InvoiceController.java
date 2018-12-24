package com.antoszek.controller;

import com.antoszek.model.Invoice;
import com.antoszek.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/app/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/all_invoices")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Invoice> getUsers() {
        List<Invoice> invoiceList = invoiceService.findAll();
        return invoiceList;
    }

    @RequestMapping("/add_new_invoice")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Invoice save(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.save(invoice);
//        log.info("Add user {}", savedCustomer);
        return savedInvoice;
    }
    @DeleteMapping("/delete_Invoice/{id}")
    public String deleteInvoice(@PathVariable Long id){
        invoiceService.deleteInvoice(id);
        return "Pomyślnie usunieto fakture.. ";
    }
    @RequestMapping("/find_invoice_byId/{id}")
    @GetMapping(value = APPLICATION_JSON_VALUE)
    public Invoice findById(@PathVariable Long id){
        return invoiceService.findById(id);
    }


    @RequestMapping("/all_invoice_by_user_id/{id}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Invoice> getInvoiceByUserId(@PathVariable Long id){
        return invoiceService.getInvoiceByClientId(id);
    }

    @RequestMapping("/all_invoice_by_car_id/{id}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Invoice> getInvoiceByCarsId(@PathVariable Long id){
        return invoiceService.getInvoiceByCarId(id);
    }
}
