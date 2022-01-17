package com.beck.good.goods.domain;

import java.math.BigDecimal;
import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.beck.good.category.domain.BeckGoodCategory;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品对象 beck_good
 * 
 * @author beck
 * @date 2021-12-31
 */
public class BeckGood extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 商品类别 */
    @Excel(name = "商品类别")
    private String goodsType;

    /** 商品封面图片 */
    @Excel(name = "商品封面图片")
    private String coverImg;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodDesc;

    /** 包装成本 */
    @Excel(name = "包装费")
    private BigDecimal packCost;

    /** 会员价 */
    @Excel(name = "会员价")
    private BigDecimal membershipPrice;

    /** 最小购买数量 */
    @Excel(name = "最低购买量")
    private Long minBuyNum;

    /** 商品单位名称 */
    @Excel(name = "商品单位名称")
    private String unitName;

    /** 商品单位键值 */
    @Excel(name = "商品单位键值")
    private String unitValue;

    /** 销售量 */
    @Excel(name = "销售量")
    private Long salesNum;

    /** 库存 */
    @Excel(name = "库存")
    private Long stockNum;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 商品分类id */
    @Excel(name = "商品分类实体")
    private BeckGoodCategory goodCategory;

    public BeckGood() {
    }

    public BeckGood(String id) {
        this.id = id;
    }

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
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setGoodsType(String goodsType) 
    {
        this.goodsType = goodsType;
    }

    public String getGoodsType() 
    {
        return goodsType;
    }
    public void setCoverImg(String coverImg) 
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg() 
    {
        return coverImg;
    }
    public void setGoodDesc(String goodDesc) 
    {
        this.goodDesc = goodDesc;
    }

    public String getGoodDesc() 
    {
        return goodDesc;
    }
    public void setPackCost(BigDecimal packCost) 
    {
        this.packCost = packCost;
    }

    public BigDecimal getPackCost() 
    {
        return packCost;
    }
    public void setMembershipPrice(BigDecimal membershipPrice) 
    {
        this.membershipPrice = membershipPrice;
    }

    public BigDecimal getMembershipPrice() 
    {
        return membershipPrice;
    }
    public void setMinBuyNum(Long minBuyNum) 
    {
        this.minBuyNum = minBuyNum;
    }

    public Long getMinBuyNum() 
    {
        return minBuyNum;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setUnitValue(String unitValue) 
    {
        this.unitValue = unitValue;
    }

    public String getUnitValue() 
    {
        return unitValue;
    }
    public void setSalesNum(Long salesNum) 
    {
        this.salesNum = salesNum;
    }

    public Long getSalesNum() 
    {
        return salesNum;
    }
    public void setStockNum(Long stockNum) 
    {
        this.stockNum = stockNum;
    }

    public Long getStockNum() 
    {
        return stockNum;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }

    public BeckGoodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(BeckGoodCategory goodCategory) {
        this.goodCategory = goodCategory;
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
            .append("price", getPrice())
            .append("goodsType", getGoodsType())
            .append("coverImg", getCoverImg())
            .append("goodDesc", getGoodDesc())
            .append("packCost", getPackCost())
            .append("membershipPrice", getMembershipPrice())
            .append("minBuyNum", getMinBuyNum())
            .append("unitName", getUnitName())
            .append("unitValue", getUnitValue())
            .append("salesNum", getSalesNum())
            .append("stockNum", getStockNum())
            .append("sort", getSort())
            .toString();
    }
}
