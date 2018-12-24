package com.antoszek.service;

import com.antoszek.model.Invoice;
import com.antoszek.model.enumClass.CarClass;
import com.antoszek.repository.InvoiceRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice save(Invoice invoice){
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return savedInvoice;
    }


    public List<Invoice> findAll() {
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<Invoice> invoices = Lists.newArrayList(invoiceIterable);

        return invoices;
    }
    public Invoice findById(Long id) {
        Optional<Invoice> client = invoiceRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        }
        return null;
    }

    public String deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
        return "Client został pomyślnie wyrejestrowany";

    }
    public List<Invoice> getInvoiceByClientId(Long id) {
        return invoiceRepository.getInvoiceByClient_id(id);
    }

    public List<Invoice> getInvoiceByCarId(Long id) {
        return invoiceRepository.getInvoiceByCar_id(id);
    }



}
