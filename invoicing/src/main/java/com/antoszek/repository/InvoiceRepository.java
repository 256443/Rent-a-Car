package com.antoszek.repository;

import com.antoszek.model.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository <Invoice, Long> {

    @Query(value = "SELECT p FROM Invoice p WHERE p.client_id=?1")
    List<Invoice> getInvoiceByClient_id(Long id);

    @Query(value = "SELECT p FROM Invoice p WHERE p.car_id=?1")
    List<Invoice> getInvoiceByCar_id(Long id);
}
