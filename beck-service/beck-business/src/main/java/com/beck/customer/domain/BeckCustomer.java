package com.beck.customer.domain;

import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户对象 beck_customer
 * 
 * @author beck
 * @date 2021-10-20
 */
public class BeckCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键,唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 登录账号 */
    @Excel(name = "登录账号")
    private String loginName;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String loginPassword;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String loginPhoto;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobile;

    /** 微信用户小程序唯一标识 */
    @Excel(name = "微信用户小程序唯一标识")
    private String wxOpenid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setLoginPassword(String loginPassword) 
    {
        this.loginPassword = loginPassword;
    }

    public String getLoginPassword() 
    {
        return loginPassword;
    }
    public void setLoginPhoto(String loginPhoto) 
    {
        this.loginPhoto = loginPhoto;
    }

    public String getLoginPhoto() 
    {
        return loginPhoto;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setWxOpenid(String wxOpenid) 
    {
        this.wxOpenid = wxOpenid;
    }

    public String getWxOpenid() 
    {
        return wxOpenid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("loginName", getLoginName())
            .append("loginPassword", getLoginPassword())
            .append("loginPhoto", getLoginPhoto())
            .append("nickName", getNickName())
            .append("mobile", getMobile())
            .append("wxOpenid", getWxOpenid())
            .toString();
    }
}
