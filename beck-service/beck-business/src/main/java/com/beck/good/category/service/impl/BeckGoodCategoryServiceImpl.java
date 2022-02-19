package com.beck.good.category.service.impl;

import java.util.List;
import com.beck.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beck.good.category.mapper.BeckGoodCategoryMapper;
import com.beck.good.category.domain.BeckGoodCategory;
import com.beck.good.category.service.IBeckGoodCategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author beck
 * @date 2021-12-10
 */
@Service
public class BeckGoodCategoryServiceImpl implements IBeckGoodCategoryService 
{
    @Autowired
    private BeckGoodCategoryMapper beckGoodCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类ID
     * @return 商品分类
     */
    @Override
    public BeckGoodCategory selectBeckGoodCategoryById(String id)
    {
        return beckGoodCategoryMapper.selectBeckGoodCategoryById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param beckGoodCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<BeckGoodCategory> selectBeckGoodCategoryList(BeckGoodCategory beckGoodCategory)
    {
        beckGoodCategory.setDelFlag("0");
        return beckGoodCategoryMapper.selectBeckGoodCategoryList(beckGoodCategory);
    }

    /**
     * 查询商品分类列表
     *
     * @param beckGoodCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<BeckGoodCategory> selectBeckGoodCategoryListNew(BeckGoodCategory beckGoodCategory)
    {
        beckGoodCategory.setDelFlag("0");
        return beckGoodCategoryMapper.selectBeckGoodCategoryListNew(beckGoodCategory);
    }
    /**
     * 新增商品分类
     * 
     * @param beckGoodCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertBeckGoodCategory(BeckGoodCategory beckGoodCategory)
    {
        beckGoodCategory.setCreateTime(DateUtils.getNowDate());
        beckGoodCategory.setDelFlag("0");
        return beckGoodCategoryMapper.insertBeckGoodCategory(beckGoodCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param beckGoodCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateBeckGoodCategory(BeckGoodCategory beckGoodCategory)
    {
        beckGoodCategory.setUpdateTime(DateUtils.getNowDate());
        return beckGoodCategoryMapper.updateBeckGoodCategory(beckGoodCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类ID
     * @return 结果
     */
    @Override
    public int deleteBeckGoodCategoryByIds(String[] ids)
    {
        return beckGoodCategoryMapper.deleteByLogicBeckGoodCategoryByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类ID
     * @return 结果
     */
    @Override
    public int deleteBeckGoodCategoryById(String id)
    {
        return beckGoodCategoryMapper.deleteByLogicBeckGoodCategoryById(id);
    }
}
