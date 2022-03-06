package com.yidong.yun.config;

import com.yidong.yun.util.MybatisInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Slf4j
//@Configuration
public class MyBatisConfig {

  //  @Bean
    public MybatisInterceptor  mybatisInterceptor(){
        return new MybatisInterceptor();
    }


    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();


    }



}
