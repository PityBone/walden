package com.oops.walden.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oops.walden.entity.DomainInfo;

/**
 * @author ljh
 * @since 2021/9/29 17:04
 */
public interface DomainInfoService extends IService<DomainInfo> {
    String getDomainInfo();

    String getDomainInfoByDomain(String domain);
}
