package com.beck.specs.service;

import java.util.List;
import com.beck.specs.domain.BeckGoodSpecsCategory;

/**
 * 商品规格分类Service接口
 * 
 * @author beck
 * @date 2021-12-10
 */
public interface IBeckGoodSpecsCategoryService 
{
    /**
     * 查询商品规格分类
     * 
     * @param id 商品规格分类ID
     * @return 商品规格分类
     */
    public BeckGoodSpecsCategory selectBeckGoodSpecsCategoryById(String id);

    /**
     * 查询商品规格分类列表
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 商品规格分类集合
     */
    public List<BeckGoodSpecsCategory> selectBeckGoodSpecsCategoryList(BeckGoodSpecsCategory beckGoodSpecsCategory);

    /**
     * 新增商品规格分类
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 结果
     */
    public int insertBeckGoodSpecsCategory(BeckGoodSpecsCategory beckGoodSpecsCategory);

    /**
     * 修改商品规格分类
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 结果
     */
    public int updateBeckGoodSpecsCategory(BeckGoodSpecsCategory beckGoodSpecsCategory);

    /**
     * 批量删除商品规格分类
     * 
     * @param ids 需要删除的商品规格分类ID
     * @return 结果
     */
    public int deleteBeckGoodSpecsCategoryByIds(String[] ids);

    /**
     * 删除商品规格分类信息
     * 
     * @param id 商品规格分类ID
     * @return 结果
     */
    public int deleteBeckGoodSpecsCategoryById(String id);
}
