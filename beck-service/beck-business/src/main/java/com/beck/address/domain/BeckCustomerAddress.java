package com.beck.address.domain;

import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.beck.customer.domain.BeckCustomer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 收货地址对象 beck_customer_address
 * 
 * @author beck
 * @date 2021-11-22
 */
public class BeckCustomerAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 收货人姓名 */
    @Excel(name = "收货人姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String address;

    /** 门牌号 */
    @Excel(name = "门牌号")
    private String doorNumber;

    /** 会员用户 */
    @Excel(name = "会员用户")
    private BeckCustomer user;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setDoorNumber(String doorNumber) 
    {
        this.doorNumber = doorNumber;
    }

    public String getDoorNumber() 
    {
        return doorNumber;
    }

    public BeckCustomer getUser() {
        return user;
    }

    public void setUser(BeckCustomer user) {
        this.user = user;
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
            .append("name", getName())
            .append("sex", getSex())
            .append("mobile", getMobile())
            .append("address", getAddress())
            .append("doorNumber", getDoorNumber())
            .append("user", getUser())
            .toString();
    }
}
