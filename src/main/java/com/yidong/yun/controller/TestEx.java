package com.yidong.yun.controller;


import com.yidong.yun.exception.BizException;
import com.yidong.yun.exception.SysException;
import com.yidong.yun.exception.ZException;
import com.yidong.yun.log.OperateLogMessage;
import com.yidong.yun.pojo.Zy;
import com.yidong.yun.statistics.MethodElapsedStatistic;
import com.yidong.yun.valid.CidrCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
public class TestEx {


    @GetMapping("/BizException")
    public String getBizResponse(){

            if (Math.random()>0.5){
                    throw  new BizException("抛异常");
            }
            return "BizException";
    }

    @GetMapping("/SysException")
    public String getSysException(){

            if (Math.random()>0.2){
                throw  new ZException("异常",new Throwable("123"));
            }else if (Math.random()>0.5){
                throw  new ZException("抛异常");
            }
            return "SysException";
    }

    @GetMapping("/log")
    public String getOperateLogMessage(){

        OperateLogMessage operateLogMessage = new OperateLogMessage("1","123", OperateLogMessage.Type.ORDER, OperateLogMessage.OperateType.ADD,new Date(),true,"hhh","回应",true);

        System.out.println(operateLogMessage.toString());

        return operateLogMessage.toString();
    }

    @GetMapping("/Statistic")
    public String getStatistic(){


        MethodElapsedStatistic m = MethodElapsedStatistic.fromSummaryStatistics("getStatistic", new LongSummaryStatistics());

        System.out.println(m);

        return m.toString();
    }


    @GetMapping("/Validator")
    public String getValidator(@Valid Zy  zy){
        return zy.getIp();
    }


    public static void main(String[] args) {


        Collection<Integer>  arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        Iterator<Integer> iterator = arr.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }



}
