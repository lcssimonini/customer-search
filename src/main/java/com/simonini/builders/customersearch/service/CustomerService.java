package com.simonini.builders.customersearch.service;

import com.simonini.builders.customersearch.dto.CreateCustomerDTO;
import com.simonini.builders.customersearch.dto.CustomerDTO;
import com.simonini.builders.customersearch.dto.UpdateCustomerDTO;
import com.simonini.builders.customersearch.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerService {

    CustomerDTO createClient(CreateCustomerDTO createCustomerDTO);

    Page<CustomerDTO> findAll(Specification<Customer> clientSpec, Pageable pageable);

    CustomerDTO findById(Long id);

    void delete(Long id);

    CustomerDTO updateClient(Long id, CreateCustomerDTO createCustomerDTO);

    CustomerDTO patchClient(Long id, UpdateCustomerDTO updateCustomerDTO);
}
