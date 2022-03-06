package com.yidong.yun.authentication;

import lombok.Data;

import java.io.Serializable;


@Data
public class EpcOAuthenticationDetails implements Serializable {

    private static final long serialVersionUID = -1270919407051294938L;


    private String  token;
    private String username;


}
