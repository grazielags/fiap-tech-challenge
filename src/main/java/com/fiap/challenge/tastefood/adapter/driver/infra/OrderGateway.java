package com.fiap.challenge.tastefood.adapter.driver.infra;

import com.fiap.challenge.tastefood.core.domain.entity.OrderEntity;
import com.fiap.challenge.tastefood.core.domain.entity.OrderStatusEnum;

import java.util.List;
import java.util.Optional;

public interface OrderGateway {

	List<OrderEntity> findAll();

	Long create(OrderEntity orderEntity);

	List<OrderEntity> findByStatus(OrderStatusEnum status);

	Optional<OrderEntity> findbyId(Long idOrder);

	OrderEntity updateStatusOrder(Long id, OrderStatusEnum orderStatusEnum);

	OrderEntity update(OrderEntity orderEntity);

}
