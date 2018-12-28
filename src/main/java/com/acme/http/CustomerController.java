package com.acme.http;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    private static final String PATH = "customers";

    @PostMapping(value = PATH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createCustomer() {

        var location = ServletUriComponentsBuilder
                .fromPath(PATH).path("/{id}")
                .buildAndExpand(1).toUri();

        return ResponseEntity
                .created(location)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body("{}");
    }

    @GetMapping(value = PATH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List getCustomers() {
        return Collections.emptyList();
    }
}
