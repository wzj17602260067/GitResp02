package com.yidong.yun.authentication;

public interface EpcOAuth2Authentication {

    // 获取凭据
    public Object getCredentials();

    // 获取用户
    public Object getPrincipal();


    public EpcOAuthenticationDetails getDetails();

}
