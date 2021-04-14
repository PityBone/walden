package com.oops.walden.entity;


import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 问卷表
 * </p>
 *
 * @author lijinhu
 * @since 2021-04-13
 */
@Data
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private String userId;

    @TableField("user_name")
    private String userName;


}
