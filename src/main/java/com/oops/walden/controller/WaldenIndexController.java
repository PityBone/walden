package com.oops.walden.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.oops.walden.entity.R;
import com.oops.walden.entity.UserInfo;
import com.oops.walden.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: LiJinHu
 * @Description:
 * @Date: Create in 22:53 2021/4/12
 */
@Controller
@RequestMapping(value = "walden")
public class WaldenIndexController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping(value = "getMessage")
    public R getMessage(@RequestParam(value = "message") String message){
        return userInfoService.getMessage(message);
    }

    @GetMapping(value = "getUserInfoById")
    public R getUserInfoById(@RequestParam(value = "userId") String userId){
        UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, userId));
        return R.ok(userInfo);
    }
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "jack");
        model.addAttribute("age", 20);
        model.addAttribute("info", "我是一个爱学习的好青年");
        return "index";
    }
}
