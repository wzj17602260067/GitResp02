package com.yidong.yun.log;

import java.util.Date;


import com.google.common.base.MoreObjects;



public class OperateLogMessage {


    /**
     * id
     */
     private String id;


    /**
     * 创建用户
     */

    private String createdBy;

    /**
     * 类型
     */

    private Type type;

    /**
     * 操作类型
     */
    private OperateType operateType;

    /**
     * ip信息
     */

    private String ip;

    /**
     * 端口
     */

    private Integer port;


    /**
     * mac地址
     */

    private String mac;

    /**
     * 具体操作
     */

    private String operate;

    /**
     * 创建时间
     */

    private Date createdAt;

    /**
     * 是否成功
     */

    private Boolean success;

    /**
     * 参数信息
     */

     private String message;

    /**
     * 返回值
     */

    private String response;

    /**
     * 区别前后端调用
     */

    private Boolean frontend;


    /**
     * 类型:
     * USER: 用户
     * ORDER: 订单
     * PRODUCT: 产品
     * TICKET: 工单
     * INSTANCE: 虚拟机
     * VOLUME: 块存储
     * OTHER: 其他
     */
    public enum Type{
        USER,ORDER,PRODUCT,TICKET,INSTANCE,VOLUME,OTHER;
    }

    /**
     * 操作类型:
     * ADD:   创建
     * DELETE:  删除
     * UPDATE:  更新
     * VIEW: 查询
     * LOGIN: 登陆
     * LOGOUT: 登出
     * OTHER: 其他
     */

    public enum OperateType{
        ADD,DELETE,UPDATE,VIEW,LOGIN,OTHER;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public OperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateType operateType) {
        this.operateType = operateType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getFrontend() {
        return frontend;
    }

    public void setFrontend(Boolean frontend) {
        this.frontend = frontend;
    }

    //json 反序列化默认需要无参构造
    public OperateLogMessage(){};


    public OperateLogMessage(String id, String createdBy, Type type, OperateType operateType, Date createdAt, Boolean success, String message, String response, Boolean frontend) {
        this.id = id;
        this.createdBy = createdBy;
        this.type = type;
        this.operateType = operateType;
        this.createdAt = createdAt;
        this.success = success;
        this.message = message;
        this.response = response;
        this.frontend = frontend;
    }


    @Override
    public String toString() {

        System.out.println("执行 **********************************");

      return MoreObjects.toStringHelper(this).add("id", id).add("createdBy", createdBy)
                .add("operateType", operateType).add("operate", operate).add("ip", ip).add("port", port)
                .add("mac", mac).add("createdAt", createdAt).add("success", success).add("message", message)
                .add("response", response).toString();
    }
}
