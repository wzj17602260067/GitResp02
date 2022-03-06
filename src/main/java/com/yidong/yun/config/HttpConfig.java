package com.yidong.yun.config;


import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpConfig {


    public static void main(String[] args) {


//        Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).forEach( t -> {
//
//            System.err.println(t);
//
//        });

//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 5, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
//
//
//        poolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//                Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).forEach( t -> {
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(t);
//
//                });
//
//            }
//        });
//
//
//        System.out.println("yes");

    }




}
