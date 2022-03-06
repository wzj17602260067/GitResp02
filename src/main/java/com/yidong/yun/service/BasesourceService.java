package com.yidong.yun.service;

import com.yidong.yun.pojo.Basesource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasesourceService {


        List<Basesource> getSourceList(String name);

        void getAsync();


}
