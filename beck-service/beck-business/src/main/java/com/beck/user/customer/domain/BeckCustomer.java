package com.beck.user.customer.domain;

import com.beck.user.address.domain.BeckCustomerAddress;
import com.beck.user.assets.domain.BeckCustomerAssets;
import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

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

    /*真实姓名*/
    @Excel(name = "真实姓名")
    private String realName;

    /*性别*/
    @Excel(name = "性别")
    private String gender;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobile;

    /** 微信用户小程序唯一标识 */
    @Excel(name = "微信用户小程序唯一标识")
    private String wxOpenid;

    @Excel(name = "用户来源")
    private String customerSource;

    @Excel(name = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Excel(name = "用户资产")
    private BeckCustomerAssets beckCustomerAssets;
    /**
     * 用户地址
     */
    private List<BeckCustomerAddress> beckCustomerAddresses;

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

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BeckCustomerAssets getBeckCustomerAssets() {
        return beckCustomerAssets;
    }

    public void setBeckCustomerAssets(BeckCustomerAssets beckCustomerAssets) {
        this.beckCustomerAssets = beckCustomerAssets;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BeckCustomer(String id) {
        this.id = id;
    }

    public BeckCustomer() {
    }

    public List<BeckCustomerAddress> getBeckCustomerAddresses() {
        return beckCustomerAddresses;
    }

    public void setBeckCustomerAddresses(List<BeckCustomerAddress> beckCustomerAddresses) {
        this.beckCustomerAddresses = beckCustomerAddresses;
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
            .append("customerSource", getCustomerSource())
            .append("realName", getRealName())
            .append("gender", getGender())
            .append("birthday",getBirthday())
            .toString();
    }
}
