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

    public CartsItemException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
