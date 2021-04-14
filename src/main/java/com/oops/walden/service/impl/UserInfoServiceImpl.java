package com.oops.walden.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oops.walden.entity.R;
import com.oops.walden.entity.UserInfo;
import com.oops.walden.mapper.UserInfoMapper;
import com.oops.walden.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 问卷表 服务实现类
 * </p>
 *
 * @author lijinhu
 * @since 2021-04-13
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public R getMessage(String message) {
        UserInfo userInfo = userInfoMapper.getUserInfo();
        return R.ok(userInfo);
    }
}
