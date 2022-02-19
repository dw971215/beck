package com.beck.good.category.domain;

import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.beck.good.goods.domain.BeckGood;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 商品分类对象 beck_good_category
 * 
 * @author beck
 * @date 2021-12-10
 */
public class BeckGoodCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String name;

    /** 图标地址 */
    @Excel(name = "图标地址")
    private String icon;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 分类商品信息明细
     */
    @JsonProperty(value = "goods_list")
    private List<BeckGood> goodsList;

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
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public BeckGoodCategory() {
    }

    public BeckGoodCategory(String id) {
        this.id = id;
    }

    public List<BeckGood> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<BeckGood> goodsList) {
        this.goodsList = goodsList;
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
            .append("icon", getIcon())
            .append("sort", getSort())
            .toString();
    }
}
