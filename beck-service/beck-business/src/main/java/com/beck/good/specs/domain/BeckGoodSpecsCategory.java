package com.beck.good.specs.domain;

import java.util.List;
import com.beck.common.annotation.Excel;
import com.beck.common.core.domain.BaseEntity;
import com.beck.good.goods.domain.BeckGood;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品规格分类对象 beck_good_specs_category
 * 
 * @author beck
 * @date 2021-12-10
 */
public class BeckGoodSpecsCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private String id;

    /** 删除标识 */
    private String delFlag;

    /** 规格分类名称 */
    @Excel(name = "规格分类名称")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 关联的商品信息 */
    private BeckGood goodVo;

    /** 商品规格属性信息 */
    private List<BeckGoodSpecsProperty> beckGoodSpecsPropertyList;

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
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public List<BeckGoodSpecsProperty> getBeckGoodSpecsPropertyList()
    {
        return beckGoodSpecsPropertyList;
    }

    public void setBeckGoodSpecsPropertyList(List<BeckGoodSpecsProperty> beckGoodSpecsPropertyList)
    {
        this.beckGoodSpecsPropertyList = beckGoodSpecsPropertyList;
    }

    public BeckGood getGoodVo() {
        return goodVo;
    }

    public void setGoodVo(BeckGood goodVo) {
        this.goodVo = goodVo;
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
            .append("sort", getSort())
            .append("goodVo",getGoodVo())
            .append("beckGoodSpecsPropertyList", getBeckGoodSpecsPropertyList())
            .toString();
    }
}
