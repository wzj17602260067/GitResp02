package com.yidong.yun.statistics;

import lombok.Data;

import java.util.Date;

@Data
public class MethodElapsedTime {

    /**
     * 唯一标识
     */

    private String id;

    /**
     * 简单方法名
     */

    private String methodName;

    /**
     * 完整方法名 包括包路径
     */

    private String fullMethodName;

    /**
     * 方法执行时间
     */

    private Long elapsedTime;

    /**
     * 服务名
     */

    private String serviceName;

    /**
     * 方法开始时间
     */

    private Date startAt;

    /**
     * 方法结束时间
     */

    private Date endAt;

    private enum OrderBy{
        START_AT,
        ELAPSED_TIME;
    }


    public MethodElapsedTime(){
    }

    public MethodElapsedTime(String methodName, Long elapsedTime) {
        this.methodName = methodName;
        this.elapsedTime = elapsedTime;
    }

    public MethodElapsedTime(String methodName, Long elapsedTime, String serviceName, Date startAt, Date endAt) {
        this.methodName = methodName;
        this.elapsedTime = elapsedTime;
        this.serviceName = serviceName;
        this.startAt = startAt;
        this.endAt = endAt;
    }


    public static MethodElapsedTime demo(String methodName, Long elapsedTime){

        MethodElapsedTime m = new MethodElapsedTime();

        m.methodName = methodName;
        m.elapsedTime = elapsedTime;
        m.startAt = new Date();
        m.endAt = new Date();
        return m;





    }

}
