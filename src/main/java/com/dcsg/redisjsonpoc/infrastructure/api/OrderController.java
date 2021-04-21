package com.dcsg.redisjsonpoc.infrastructure.api;

import com.dcsg.redisjsonpoc.model.OrderCacheService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class OrderController {

    @Autowired
//    @Qualifier("orderCacheService")
    private final OrderCacheService orderCacheService;
//    private OrderDTO orderDTO;

    public OrderController(OrderCacheService orderCacheService) {
        this.orderCacheService = orderCacheService;
    }

    @PostMapping(value = "/order")
    @ResponseStatus(HttpStatus.OK)
    public void chacheOrder(@RequestBody OrderDTO orderDTO) {

        Preconditions.checkNotNull(orderDTO);
        var orderNumber = orderDTO.getOrderNumber();
        try {
            orderCacheService.setOrderCache(orderNumber, orderDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/order/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderStatus(@RequestBody String orderStatus, String orderNumber) {
        try {
            orderCacheService.updateOrderStatus(orderNumber, orderStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/order")
    @ResponseBody
    public OrderDTO getOrder(@RequestParam String orderNumber) {
        OrderDTO orderDTO = orderCacheService.findOrder(orderNumber);
        return orderDTO;
    }

}
