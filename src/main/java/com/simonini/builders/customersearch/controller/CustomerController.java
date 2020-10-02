package com.simonini.builders.customersearch.controller;

import com.simonini.builders.customersearch.dto.CustomerDTO;
import com.simonini.builders.customersearch.dto.CreateCustomerDTO;
import com.simonini.builders.customersearch.dto.UpdateCustomerDTO;
import com.simonini.builders.customersearch.model.Customer;
import com.simonini.builders.customersearch.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public Page<CustomerDTO> findAll(
            @And({@Spec(path = "document", spec = Like.class), @Spec(path = "name", spec = Like.class)})
                    Specification<Customer> customerSpec, Pageable pageable) {
        return service.findAll(customerSpec, pageable);
    }

    @PostMapping
    public CustomerDTO createClient(@Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
        return service.createClient(createCustomerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateClient(@PathVariable Long id, @Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
        return service.updateClient(id, createCustomerDTO);
    }

    @PatchMapping("/{id}")
    public CustomerDTO patchClient(@PathVariable Long id, @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return service.patchClient(id, updateCustomerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public CustomerDTO getClient(@PathVariable Long id) {
        return service.findById(id);
    }
}
