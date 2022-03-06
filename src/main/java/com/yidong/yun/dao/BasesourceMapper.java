package com.yidong.yun.dao;

import com.yidong.yun.pojo.Basesource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasesourceMapper {


      void insertSource();

      List<Basesource> selectAll(@Param("name") String name);



}
