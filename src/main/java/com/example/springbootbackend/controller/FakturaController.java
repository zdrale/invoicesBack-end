package com.example.springbootbackend.controller;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Faktura;
import com.example.springbootbackend.repository.FakturaRepository;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/faktura")
public class FakturaController {
    @Autowired
    private FakturaRepository fakturaRepository;


    @GetMapping
    public List<Faktura> GetAllInvoices(){
        return fakturaRepository.findAll();
    }

    @PostMapping
    public Faktura createInvoices(@RequestBody Faktura faktura) {
        return fakturaRepository.save(faktura);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faktura> getInvoiceById(@PathVariable long id){
        Faktura invoice = fakturaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice does not exist with id: " + id));

        return ResponseEntity.ok(invoice);
    }

    @PutMapping("{id}")
    public ResponseEntity<Faktura> updateInvoice(@PathVariable long id, @RequestBody Faktura invoiceDetails){
        Faktura updateInvoice = fakturaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice does not exist with id: " + id));
        updateInvoice.setSellerName(invoiceDetails.getSellerName());
        updateInvoice.setCustomerName(invoiceDetails.getCustomerName());
        updateInvoice.setDate(invoiceDetails.getDate());
        updateInvoice.setAmount(invoiceDetails.getAmount());

        fakturaRepository.save(updateInvoice);

        return  ResponseEntity.ok(updateInvoice);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteInvoice(@PathVariable Long id){
        Faktura faktura = fakturaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice does not exist with id: " + id));

        fakturaRepository.delete(faktura);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
