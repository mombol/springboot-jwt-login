package com.mombol.common.handler;

import com.mombol.common.exception.MombolBindException;
import com.mombol.common.response.ResponseBodyEntity;
import com.mombol.common.response.ResponseCode;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    public ResponseBodyEntity<Object> exceptionHandler(BindException e) {
        return ResponseBodyEntity.fail(
                ResponseCode.BAD_REQUEST.getCode(),
                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage()
        );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseBodyEntity<Object> exceptionHandler(MethodArgumentNotValidException e) {
        return ResponseBodyEntity.fail(
                ResponseCode.BAD_REQUEST.getCode(),
                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage()
        );
    }

    @ExceptionHandler(value = MombolBindException.class)
    public ResponseBodyEntity<Object> exceptionHandler(MombolBindException e) {
        return ResponseBodyEntity.fail(
                ResponseCode.BAD_REQUEST.getCode(),
                e.getMessage()
        );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseBodyEntity<Object> exceptionHandler(Exception e) {
        return ResponseBodyEntity.fail(ResponseCode.INTERNAL_SERVER_ERROR);
    }

}
