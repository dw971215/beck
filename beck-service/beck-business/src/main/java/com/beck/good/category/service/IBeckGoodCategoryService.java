package com.beck.good.category.service;

import java.util.List;
import com.beck.good.category.domain.BeckGoodCategory;

/**
 * 商品分类Service接口
 * 
 * @author beck
 * @date 2021-12-10
 */
public interface IBeckGoodCategoryService 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类ID
     * @return 商品分类
     */
    public BeckGoodCategory selectBeckGoodCategoryById(String id);

    /**
     * 查询商品分类列表
     * 
     * @param beckGoodCategory 商品分类
     * @return 商品分类集合
     */
    public List<BeckGoodCategory> selectBeckGoodCategoryList(BeckGoodCategory beckGoodCategory);

    /**
     * 新增商品分类
     * 
     * @param beckGoodCategory 商品分类
     * @return 结果
     */
    public int insertBeckGoodCategory(BeckGoodCategory beckGoodCategory);

    /**
     * 修改商品分类
     * 
     * @param beckGoodCategory 商品分类
     * @return 结果
     */
    public int updateBeckGoodCategory(BeckGoodCategory beckGoodCategory);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类ID
     * @return 结果
     */
    public int deleteBeckGoodCategoryByIds(String[] ids);

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类ID
     * @return 结果
     */
    public int deleteBeckGoodCategoryById(String id);
}
