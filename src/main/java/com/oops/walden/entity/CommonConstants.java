/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.oops.walden.entity;

/**
 * @author lengleng
 * @date 2017/10/29
 */
public interface CommonConstants {
	/**
	 * header 中租户ID
	 */
	String TENANT_ID = "TENANT-ID";

	String AUTHORIZATION = "Authorization";

	/**
	 * header 中版本信息
	 */
	String VERSION = "VERSION";

	/**
	 * 租户ID
	 */
	String TENANT_ID_1 = "1";

	/**
	 * 学员所属租户
	 */
	String TENANT_ID_STU = "-1";

	/**
	 * 学慧网根部门id
	 */
	String XHW_ROOT_DEPT_ID = "1";

	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 菜单
	 */
	String MENU = "1";

	/**
	 * 菜单-功能页面
	 */
	String MENU_PAGE = "2";

	/**
	 * 菜单树根节点
	 */
	String MENU_TREE_ROOT_ID = "-1";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "pigx-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "pigx";

	/**
	 * 公共参数
	 */
	String PIG_PUBLIC_PARAM_KEY = "PIG_PUBLIC_PARAM_KEY";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;
	/**
	 * 默认存储bucket
	 */
	String BUCKET_NAME = "xhw";
	/**
	 * 签章存储bucket
	 */
	String BUCKET_SIGN = "sign";
	/**
	 * 百科系统存储bucket
	 */
	String BUCKET_ENCYCLOPEDIA = "encyclopedia";
	/**
	 * ai上传录音bucket
	 */
	String BUCKET_COMMUNICATION = "communication";
}
