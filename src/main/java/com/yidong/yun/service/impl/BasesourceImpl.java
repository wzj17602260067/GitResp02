package com.yidong.yun.service.impl;


import com.yidong.yun.dao.BasesourceMapper;
import com.yidong.yun.pojo.Basesource;
import com.yidong.yun.service.BasesourceService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@EnableAsync
public class BasesourceImpl implements BasesourceService {



    @Autowired
    private BasesourceMapper basesourceMapper;


    @Override
    public List<Basesource> getSourceList(String name) {

        List<Basesource> basesources = basesourceMapper.selectAll(name);

        return basesources;

    }

    @Override
    @Async
    public void getAsync() {



        Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).forEach(t -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println(t);

        });

    }


}
