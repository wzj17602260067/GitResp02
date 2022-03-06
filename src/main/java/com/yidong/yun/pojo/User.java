package com.yidong.yun.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "user",ignoreInvalidFields = true)
@Data
public class User {

    String hha;
    Integer age;
    Double price;





}
