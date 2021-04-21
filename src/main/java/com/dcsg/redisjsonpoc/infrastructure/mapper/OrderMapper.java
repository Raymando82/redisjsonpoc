package com.dcsg.redisjsonpoc.infrastructure.mapper;

import com.dcsg.redisjsonpoc.infrastructure.api.OrderDTO;
import com.dcsg.redisjsonpoc.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderDTOOTOOrder(OrderDTO orderDTO);

    OrderDTO orderToOrderDTO(Order order);

}
