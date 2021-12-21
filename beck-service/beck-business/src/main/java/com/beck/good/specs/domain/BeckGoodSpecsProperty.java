package com.beck.good.specs.domain;

import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品规格属性对象 beck_good_specs_property
 * 
 * @author beck
 * @date 2021-12-10
 */
public class BeckGoodSpecsProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String name;

    /** 规格属性编码 */
    @Excel(name = "规格属性编码")
    private String code;

    /** $column.columnComment */
    @Excel(name = "是否默认")
    private String isDefault;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 规格分类id */
    @Excel(name = "规格分类id")
    private String specsCategoryId;

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
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setIsDefault(String isDefault) 
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault() 
    {
        return isDefault;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setSpecsCategoryId(String specsCategoryId) 
    {
        this.specsCategoryId = specsCategoryId;
    }

    public String getSpecsCategoryId() 
    {
        return specsCategoryId;
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
            .append("code", getCode())
            .append("isDefault", getIsDefault())
            .append("sort", getSort())
            .append("specsCategoryId", getSpecsCategoryId())
            .toString();
    }
}
