package com.oops.walden.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author ljh
 * @since 2021/9/29 17:01
 */
@Data
@Builder
@TableName(value = "domain_info_3")
public class DomainInfo {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String domain;
    private String result;
    private Boolean status;
}
