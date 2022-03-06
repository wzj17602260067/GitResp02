package com.yidong.yun.exception;

public class ZException extends SysException{



        public ZException(String message,Throwable throwable){
            super(message,throwable);
        }

        public ZException(String message){
            super(message);
        }




}
