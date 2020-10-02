package com.simonini.builders.customersearch.model;

import com.simonini.builders.customersearch.dto.CreateCustomerDTO;
import com.simonini.builders.customersearch.dto.UpdateCustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String document;
    private LocalDate birthDate;

    public static Customer from(CreateCustomerDTO createCustomerDTO) {
        return Customer.builder()
                .name(createCustomerDTO.getName())
                .document(createCustomerDTO.getDocument())
                .birthDate(createCustomerDTO.getBirthDate())
                .build();
    }

    public void patch(UpdateCustomerDTO updateCustomerDTO) {
        if (updateCustomerDTO.getName() != null) {
            setName(updateCustomerDTO.getName());
        }

        if (updateCustomerDTO.getDocument() != null) {
            setDocument(updateCustomerDTO.getDocument());
        }

        if (updateCustomerDTO.getBirthDate() != null) {
            setBirthDate(updateCustomerDTO.getBirthDate());
        }
    }
}
