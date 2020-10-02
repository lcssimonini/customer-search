package com.simonini.builders.customersearch.integration;

import com.simonini.builders.customersearch.repository.CustomerRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@TestConfiguration
@RestController
@RequestMapping("/clear")
public class DeleteAllEndpoint {

    private final CustomerRepository repository;

    public DeleteAllEndpoint(CustomerRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping
    public void clear() {
        repository.deleteAll();
    }
}
