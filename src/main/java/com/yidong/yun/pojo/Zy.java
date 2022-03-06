package com.yidong.yun.pojo;

import com.yidong.yun.valid.CidrCheck;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Data
public class Zy {

    @CidrCheck
    String ip;






}
