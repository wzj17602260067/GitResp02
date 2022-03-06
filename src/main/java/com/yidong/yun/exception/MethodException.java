package com.yidong.yun.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import javax.validation.executable.ValidateOnExecution;

@RestControllerAdvice
@Slf4j
public class MethodException {

    private static final Logger logger = LoggerFactory.getLogger(MethodException.class);

    @ExceptionHandler(BindException.class)
    public String getArgment(BindException e){


        logger.error("消息:",e.getMessage());

        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();

        return defaultMessage;

    }


}
