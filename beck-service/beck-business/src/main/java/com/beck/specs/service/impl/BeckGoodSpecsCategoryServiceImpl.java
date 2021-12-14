package com.beck.specs.service.impl;

import java.util.List;
import com.beck.common.utils.DateUtils;
import com.beck.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.beck.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.beck.specs.domain.BeckGoodSpecsProperty;
import com.beck.specs.mapper.BeckGoodSpecsCategoryMapper;
import com.beck.specs.domain.BeckGoodSpecsCategory;
import com.beck.specs.service.IBeckGoodSpecsCategoryService;

/**
 * 商品规格分类Service业务层处理
 * 
 * @author beck
 * @date 2021-12-10
 */
@Service
public class BeckGoodSpecsCategoryServiceImpl implements IBeckGoodSpecsCategoryService 
{
    @Autowired
    private BeckGoodSpecsCategoryMapper beckGoodSpecsCategoryMapper;

    /**
     * 查询商品规格分类
     * 
     * @param id 商品规格分类ID
     * @return 商品规格分类
     */
    @Override
    public BeckGoodSpecsCategory selectBeckGoodSpecsCategoryById(String id)
    {
        return beckGoodSpecsCategoryMapper.selectBeckGoodSpecsCategoryById(id);
    }

    /**
     * 查询商品规格分类列表
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 商品规格分类
     */
    @Override
    public List<BeckGoodSpecsCategory> selectBeckGoodSpecsCategoryList(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        beckGoodSpecsCategory.setDelFlag("0");
        return beckGoodSpecsCategoryMapper.selectBeckGoodSpecsCategoryList(beckGoodSpecsCategory);
    }

    /**
     * 新增商品规格分类
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBeckGoodSpecsCategory(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        beckGoodSpecsCategory.setCreateTime(DateUtils.getNowDate());
        beckGoodSpecsCategory.setDelFlag("0");
        int rows = beckGoodSpecsCategoryMapper.insertBeckGoodSpecsCategory(beckGoodSpecsCategory);
        insertBeckGoodSpecsProperty(beckGoodSpecsCategory);
        return rows;
    }

    /**
     * 修改商品规格分类
     * 
     * @param beckGoodSpecsCategory 商品规格分类
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBeckGoodSpecsCategory(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        beckGoodSpecsCategory.setUpdateTime(DateUtils.getNowDate());
        beckGoodSpecsCategoryMapper.deleteBeckGoodSpecsPropertyBySpecsCategoryId(beckGoodSpecsCategory.getId());
        insertBeckGoodSpecsProperty(beckGoodSpecsCategory);
        return beckGoodSpecsCategoryMapper.updateBeckGoodSpecsCategory(beckGoodSpecsCategory);
    }

    /**
     * 批量删除商品规格分类
     * 
     * @param ids 需要删除的商品规格分类ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBeckGoodSpecsCategoryByIds(String[] ids)
    {
        beckGoodSpecsCategoryMapper.deleteBeckGoodSpecsPropertyBySpecsCategoryIds(ids);
        return beckGoodSpecsCategoryMapper.deleteByLogicBeckGoodSpecsCategoryByIds(ids);
    }

    /**
     * 删除商品规格分类信息
     * 
     * @param id 商品规格分类ID
     * @return 结果
     */
    @Override
    public int deleteBeckGoodSpecsCategoryById(String id)
    {
        beckGoodSpecsCategoryMapper.deleteBeckGoodSpecsPropertyBySpecsCategoryId(id);
        return beckGoodSpecsCategoryMapper.deleteByLogicBeckGoodSpecsCategoryById(id);
    }

    /**
     * 新增商品规格属性信息
     * 
     * @param beckGoodSpecsCategory 商品规格分类对象
     */
    public void insertBeckGoodSpecsProperty(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        List<BeckGoodSpecsProperty> beckGoodSpecsPropertyList = beckGoodSpecsCategory.getBeckGoodSpecsPropertyList();
        String id = beckGoodSpecsCategory.getId();
        if (StringUtils.isNotNull(beckGoodSpecsPropertyList))
        {
            List<BeckGoodSpecsProperty> list = new ArrayList<BeckGoodSpecsProperty>();
            for (BeckGoodSpecsProperty beckGoodSpecsProperty : beckGoodSpecsPropertyList)
            {
                beckGoodSpecsProperty.setId(UUID.randomUUID().toString());
                beckGoodSpecsProperty.setSpecsCategoryId(id);
                list.add(beckGoodSpecsProperty);
            }
            if (list.size() > 0)
            {
                beckGoodSpecsCategoryMapper.batchBeckGoodSpecsProperty(list);
            }
        }
    }
}
