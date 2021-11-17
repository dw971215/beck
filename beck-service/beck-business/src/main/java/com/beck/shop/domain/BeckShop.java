package com.beck.shop.domain;

import java.math.BigDecimal;
import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户门店对象 beck_shop
 * 
 * @author beck
 * @date 2021-11-10
 */
public class BeckShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 区域编码 */
    @Excel(name = "区域编码")
    private String areaCode;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String mobile;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 门店经度 */
    @Excel(name = "门店经度")
    private String longitude;

    /** 门店纬度 */
    @Excel(name = "门店纬度")
    private String latitude;

    /** 门头照 */
    @Excel(name = "门头照")
    private String outDoorPhoto;

    /** 是否营业 */
    @Excel(name = "是否营业")
    private String isOpen;

    /** 最低消费额 */
    @Excel(name = "最低消费额")
    private BigDecimal minPrice;

    /** 包装费 */
    @Excel(name = "包装费")
    private BigDecimal packingFee;

    /** 配送费 */
    @Excel(name = "配送费")
    private BigDecimal deliveryCost;

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
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
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
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setOutDoorPhoto(String outDoorPhoto) 
    {
        this.outDoorPhoto = outDoorPhoto;
    }

    public String getOutDoorPhoto() 
    {
        return outDoorPhoto;
    }
    public void setIsOpen(String isOpen) 
    {
        this.isOpen = isOpen;
    }

    public String getIsOpen() 
    {
        return isOpen;
    }
    public void setMinPrice(BigDecimal minPrice) 
    {
        this.minPrice = minPrice;
    }

    public BigDecimal getMinPrice() 
    {
        return minPrice;
    }
    public void setPackingFee(BigDecimal packingFee) 
    {
        this.packingFee = packingFee;
    }

    public BigDecimal getPackingFee() 
    {
        return packingFee;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
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
            .append("shopName", getShopName())
            .append("areaCode", getAreaCode())
            .append("mobile", getMobile())
            .append("address", getAddress())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("outDoorPhoto", getOutDoorPhoto())
            .append("isOpen", getIsOpen())
            .append("minPrice", getMinPrice())
            .append("packingFee", getPackingFee())
            .append("deliveryCost", getDeliveryCost())
            .toString();
    }
}
