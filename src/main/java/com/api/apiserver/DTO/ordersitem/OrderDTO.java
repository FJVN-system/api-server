package com.api.apiserver.DTO.ordersitem;

import com.api.apiserver.domain.OrdersItem;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long itemCount;
    private Long itemQty;
    private Long totalPrice;

}
