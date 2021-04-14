package com.oops.walden.entity;

/**
 * @Author: dong
 * @Date: 2020/1/13 11:53
 * @Description:
 */
public interface ResultConstants {

	/**
	 * 未授权
	 */
	Integer UNAUTHORIZED = 403;

	/**
	 * 认证无效-需要重新认证
	 */
	Integer UNCERTIFICATED = 401;

	/**
	 * 需要修改密码
	 */
	Integer UPPWD = 405;

	/**
	 * 未使用信任设备登录
	 */
	Integer NO_DETAILS = 406;

	String NOT_PARAMS_MSG = "请传递完整参数！";
}
