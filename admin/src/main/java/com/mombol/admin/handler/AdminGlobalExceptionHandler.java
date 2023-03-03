package com.mombol.admin.handler;

import com.mombol.common.handler.GlobalExceptionHandler;
import com.mombol.common.response.ResponseBodyEntity;
import com.mombol.common.response.ResponseCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminGlobalExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseBodyEntity<Object> exceptionHandler(AccessDeniedException e) {
        return ResponseBodyEntity.fail(
                ResponseCode.BAD_REQUEST.getCode(),
                e.getMessage()
        );
    }

}
