package com.fiap.challenge.tastefood.core.application.useCase.order;

import com.fiap.challenge.tastefood.core.application.dto.OrderRequest;
import com.fiap.challenge.tastefood.core.domain.entity.Order;
import com.fiap.challenge.tastefood.core.domain.entity.OrderProduct;
import com.fiap.challenge.tastefood.core.application.mapper.OrderRequestMapper;
import com.fiap.challenge.tastefood.core.domain.repository.OrderRepository;
import com.fiap.challenge.tastefood.core.application.validator.OrderCreateValidator;
import com.fiap.challenge.tastefood.core.domain.valueObject.OrderStatus;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderCreateUseCase {

    private final OrderRequestMapper mapper;
    private final OrderRepository repository;
    private final OrderCreateValidator validator;

    @Transactional
    public Long execute(OrderRequest order) {

        validator.validate(order);

        Order entity = mapper.map(order);

        entity.setCreatedAt(LocalDateTime.now());
        entity.setStatus(OrderStatus.RECEBIDO);
        entity.setTotal(BigDecimal.ZERO);

        for (OrderProduct orderProduct : entity.getProducts()) {
            orderProduct.setOrder(entity);
            orderProduct.setPrice(orderProduct.getProduct().getPrice());
            entity.setTotal(entity.getTotal().add(BigDecimal.valueOf(orderProduct.getQuantity()).multiply(orderProduct.getPrice())));
        }

        Order saved = repository.save(entity);

        return saved.getId();
    }

}