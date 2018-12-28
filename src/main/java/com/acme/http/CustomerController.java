package com.acme.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @PostMapping("customers")
    public void createCustomer() {}

    @GetMapping("customers")
    public List getCustomers() {
        return Collections.emptyList();
    }
}
