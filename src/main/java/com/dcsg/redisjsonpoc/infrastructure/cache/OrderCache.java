package com.dcsg.redisjsonpoc.infrastructure.cache;

import com.dcsg.redisjsonpoc.model.Order;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.redislabs.modules.rejson.JReJSON;
import com.redislabs.modules.rejson.Path;
import org.springframework.stereotype.Repository;


@Repository
public class OrderCache {

    // RedisJSON connection
    JReJSON client = new JReJSON("localhost", 6379);


    public Order findByOrderNumber(String orderNumber) {
        Order order = new Gson().fromJson(new Gson().toJson(
                ((LinkedTreeMap<String, Object>)
                        client.get(orderNumber)))
                , Order.class);

        return order;
    }

    public void setOrderCache(String orderNumber, Order order) {
        client.set(orderNumber, order);
    }

    Path p = new Path(".orderStatus");

    public void updateOrderStatus(String orderNumber, String orderStatus) {
        client.set(orderNumber, orderStatus, p);
    }
}
