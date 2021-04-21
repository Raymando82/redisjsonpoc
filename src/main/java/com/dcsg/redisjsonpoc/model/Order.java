package com.dcsg.redisjsonpoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Order {

    private String orderNumber;
    private String orderStatus;
    private List<LineItem> lineItem;
}
