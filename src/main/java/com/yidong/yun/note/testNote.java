package com.yidong.yun.note;

import ch.qos.logback.core.util.TimeUtil;
import com.yidong.yun.valid.CidrCheck;

import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.concurrent.*;

public class testNote {

    @CidrCheck.List(
            {
                @CidrCheck(),
                @CidrCheck()
            }
    )
    @Params({
            @Param(name = "123", age = 456),
            @Param(name = "iop", age = 456)
    })
      public void note (int a){

          System.out.println( a );
      }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });

        //ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1);

        //ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor();


        ScheduledThreadPoolExecutor scheduledFuture = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });


         scheduledFuture.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
            }
        }, 1, 1, TimeUnit.MINUTES);


    }




}
