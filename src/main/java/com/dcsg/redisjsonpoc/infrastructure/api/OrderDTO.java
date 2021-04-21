package com.dcsg.redisjsonpoc.infrastructure.api;

import com.dcsg.redisjsonpoc.model.LineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    public String orderNumber;
    public String orderStatus;
    public List<LineItem> lineItem;
}
