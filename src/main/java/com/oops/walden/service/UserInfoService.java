package com.oops.walden.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.oops.walden.entity.R;
import com.oops.walden.entity.UserInfo;

/**
 * <p>
 * 问卷表 服务类
 * </p>
 *
 * @author lijinhu
 * @since 2021-04-13
 */
public interface UserInfoService extends IService<UserInfo> {

    R getMessage(String message);
}
