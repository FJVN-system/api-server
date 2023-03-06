package com.api.apiserver.exception;

import com.api.apiserver.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartsItemException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorMessage;

    private String productQtyMsg;


    public CartsItemException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }

    public CartsItemException(ErrorCode errorCode, Long productQty) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
        this.productQtyMsg =  productQty + "개 이하로 주문해 주세요";
    }
}
