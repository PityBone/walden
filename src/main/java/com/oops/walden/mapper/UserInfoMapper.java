package com.oops.walden.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oops.walden.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问卷表 Mapper 接口
 * </p>
 *
 * @author lijinhu
 * @since 2021-04-13
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo getUserInfo();
}
