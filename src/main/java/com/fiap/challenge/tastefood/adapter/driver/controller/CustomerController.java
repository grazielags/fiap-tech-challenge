package com.fiap.challenge.tastefood.adapter.driver.controller;

import com.fiap.challenge.tastefood.core.application.dto.CustomerRequest;
import com.fiap.challenge.tastefood.core.application.dto.CustomerResponse;
import com.fiap.challenge.tastefood.core.application.useCase.customer.CustomerCreateUseCase;
import com.fiap.challenge.tastefood.core.application.useCase.customer.CustomerListUseCase;
import com.fiap.challenge.tastefood.core.domain.mapper.CustomerRequestMapper;
import com.fiap.challenge.tastefood.core.domain.mapper.CustomerResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerCreateUseCase customerCreateUseCase;
    private final CustomerListUseCase customerListUseCase;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerResponseMapper customerResponseMapper;

    @PostMapping(path = "/customer")
    public void create(@RequestBody CustomerRequest request) {
        customerCreateUseCase.execute(customerRequestMapper.map(request));
    }

    @GetMapping(path = "/customer")
    public List<CustomerResponse> list() {
        return customerResponseMapper.map(customerListUseCase.execute());
    }

}
