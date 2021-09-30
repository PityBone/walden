package com.oops.walden.controller;

import com.oops.walden.entity.R;
import com.oops.walden.service.DomainInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ljh
 * @since 2021/9/29 17:04
 */
@RestController
@RequestMapping(value = "domain")
public class DomainInfoController {

    @Resource
    private DomainInfoService domainInfoService;

    @GetMapping(value = "getDomainInfo")
    public R<String> getDomainInfo(){
        String r = domainInfoService.getDomainInfo();
        return R.ok(r);
    }

    @GetMapping(value = "getDomainInfoByDomain")
    public R<String> getDomainInfoByDomain(@RequestParam String domain){
        String r = domainInfoService.getDomainInfoByDomain(domain);
        return R.ok(r);
    }
}
