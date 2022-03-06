package com.yidong.yun.response;

public enum Renum {


    SUCCESS(200,"成功",null),
    FAIL(201,"失败",null);

    int state;
    String message;
    String error;


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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    Renum(int state, String message, String error) {
        this.state = state;
        this.message = message;
        this.error = error;
    }
}
