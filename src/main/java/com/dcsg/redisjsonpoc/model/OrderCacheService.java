package com.dcsg.redisjsonpoc.model;

import com.dcsg.redisjsonpoc.infrastructure.api.OrderDTO;
import com.dcsg.redisjsonpoc.infrastructure.cache.OrderCache;
import com.dcsg.redisjsonpoc.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderCacheService {

    @Autowired
    private OrderCache orderCache;
    private final OrderMapper orderMapper;

    public OrderDTO findOrder(String orderNumber) {
        OrderDTO orderDTO = orderMapper.orderToOrderDTO(orderCache.findByOrderNumber(orderNumber));
//        orderDTO
        return orderDTO;
    }

    public void setOrderCache(String orderNumber, OrderDTO orderDTO) {
        Order order = orderMapper.INSTANCE.orderDTOOTOOrder(orderDTO);
        orderCache.setOrderCache(orderNumber, order);
    }

    public void updateOrderStatus(String orderNumber, String orderStatus) {
        orderCache.updateOrderStatus(orderNumber, orderStatus);
    }
}
