package com.yidong.yun.exception;

public abstract class SysException extends RuntimeException{

    private static final long serialVersionUID = -508045262564049395L;

    public SysException(){
        super();
    }

    public SysException(String message,Throwable cause){
        super(message,cause);
    }

    public SysException(String message){
        super(message);
    }

    public SysException(Throwable cause){
        super(cause);
    }

}
