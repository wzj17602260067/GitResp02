package com.yidong.yun.response;


import lombok.Builder;

@Builder
public class ResponseVo<T> {

        int state;
        String message;
        T entity;
        String error;

    public ResponseVo(int state, String message, T entity, String error) {
        this.state = state;
        this.message = message;
        this.entity = entity;
        this.error = error;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getEntity() {
        return entity;
    }
    public void setEntity(T entity) {
        this.entity = entity;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }


    public static ResponseVo Fill(String message){
        return new ResponseVo<>(Renum.FAIL.getState(),message,null,null);
    }

    public static ResponseVo Fail(String message,String error){
        return new ResponseVo<>(Renum.FAIL.getState(),message,null,error);
    }



    public static <T>ResponseVo<T> success(T entity){
        return new ResponseVo<>(Renum.SUCCESS.state,Renum.SUCCESS.message,entity,null);
    }


    public static <T>ResponseVo.ResponseVoBuilder<T> successBu(T entity){
        return new ResponseVoBuilder<T>().state(Renum.SUCCESS.getState()).message(Renum.SUCCESS.getMessage());
    }





}
