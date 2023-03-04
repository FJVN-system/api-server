package com.api.apiserver.exception;

import com.api.apiserver.DTO.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.api.apiserver.type.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.api.apiserver.type.ErrorCode.INVALID_REQUEST;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ErrorResponse handleAccountException(ProductException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleAccountException(UserException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleCartsItemException(CartsItemException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleProductMemoException(ProductMemoException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleDataIntegrityViolationExceptionException(DataIntegrityViolationException e) {

        log.error("DataIntegrityViolationException is occurred !", e);
        return new ErrorResponse(INVALID_REQUEST, INVALID_REQUEST.getDescription());
    }
    @ExceptionHandler
    public ErrorResponse handleException(Exception e) {
        log.error("Exception is occurred !", e);
        return new ErrorResponse(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.getDescription());
    }
    


}
