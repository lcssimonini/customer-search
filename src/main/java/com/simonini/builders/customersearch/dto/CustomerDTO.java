package com.simonini.builders.customersearch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simonini.builders.customersearch.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String name;
    private String document;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public String getAge() {
        if (birthDate != null) {
            return resolveAge();
        } else {
            return "0";
        }
    }

    public static CustomerDTO from(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .document(customer.getDocument())
                .birthDate(customer.getBirthDate())
                .build();
    }

    private String resolveAge() {
        return Integer.toString(getPeriod().getYears());
    }

    private Period getPeriod() {
        return Period.between(birthDate, LocalDate.now());
    }
}
