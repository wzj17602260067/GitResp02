package com.yidong.yun.pojo;


import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
@Data
@Accessors(chain =true)
public class Basesource implements Serializable {
    private static final long serialVersionUID = -6486302796415348035L;

    // uuid
    private String id;
    //资源名称
    private String name;
    //资源描述
    private String description;
    //资源创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    //资源修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
    //资源所属资源池区域ID
    private String districtId;
    //资源所属资源池ID
    private String poolId;
    //资源所属租户ID
    private String organizationId;
    //资源所属业务系统Id
    private String businessId;
    //资源订单
    private String subOrderId;
    // 资源申请人
    private String userId;
    //资源绑定Id
    private String productId;
    //资源类型(虚拟机,块存储)
    private String resourceType;
    //区域名称
    private String regionName;
    // domainName
    private String domainName;
    // 是否删除
    private Boolean deleted;
    //资源的有效期
    private Date expiredAt;
    //是否在回收站
    private Boolean isInRecycleBin;
























}
