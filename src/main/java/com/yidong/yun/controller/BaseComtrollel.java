package com.yidong.yun.controller;


import com.yidong.yun.pojo.Basesource;
import com.yidong.yun.response.ResponseVo;
import com.yidong.yun.service.BasesourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@Api("Base 调用")
@RestController

public class BaseComtrollel {


    @Autowired
    private BasesourceService basesourceService;


    @ApiImplicitParam(name="name",required=true,dataType="String",paramType="Requst")
    @GetMapping("/Base")
    public ResponseVo<List<Basesource>> getBase(@RequestParam("name") String name){

        List<Basesource> sourceList = basesourceService.getSourceList(name);
        System.out.println(sourceList);
        return ResponseVo.successBu(sourceList).entity(sourceList).build();

    }


    @GetMapping("Async")
    public String getAsync(){

        String name = Thread.currentThread().getName();

        basesourceService.getAsync();

        System.out.println("执行完成" + name);
        return name;

    }






}
