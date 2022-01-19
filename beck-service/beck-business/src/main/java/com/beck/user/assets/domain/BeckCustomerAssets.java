package com.beck.user.assets.domain;

import java.math.BigDecimal;
import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.beck.user.customer.domain.BeckCustomer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户资产对象 beck_customer_assets
 * 
 * @author beck
 * @date 2021-11-11
 */
public class BeckCustomerAssets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 会员用户id */
    @Excel(name = "会员用户")
    private BeckCustomer user;

    /** 会员积分 */
    @Excel(name = "会员积分")
    private Long pointNum;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 当前成长值 */
    @Excel(name = "当前成长值")
    private Long currentValue;

    /** 会员等级 */
    @Excel(name = "会员等级")
    private Integer memberLevel;

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

    public void setPointNum(Long pointNum)
    {
        this.pointNum = pointNum;
    }

    public Long getPointNum() 
    {
        return pointNum;
    }
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setCurrentValue(Long currentValue) 
    {
        this.currentValue = currentValue;
    }

    public Long getCurrentValue() 
    {
        return currentValue;
    }
    public void setMemberLevel(Integer memberLevel) 
    {
        this.memberLevel = memberLevel;
    }

    public Integer getMemberLevel() 
    {
        return memberLevel;
    }

    public BeckCustomer getUser() {
        return user;
    }

    public void setUser(BeckCustomer user) {
        this.user = user;
    }

    public BeckCustomerAssets() {
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
            .append("userId", getUser())
            .append("pointNum", getPointNum())
            .append("balance", getBalance())
            .append("currentValue", getCurrentValue())
            .append("memberLevel", getMemberLevel())
            .toString();
    }
}
