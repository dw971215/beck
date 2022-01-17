package com.beck.good.goods.service.impl;

import java.util.List;
import com.beck.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beck.good.goods.mapper.BeckGoodMapper;
import com.beck.good.goods.domain.BeckGood;
import com.beck.good.goods.service.IBeckGoodService;

/**
 * 商品Service业务层处理
 * 
 * @author beck
 * @date 2021-12-31
 */
@Service
public class BeckGoodServiceImpl implements IBeckGoodService 
{
    @Autowired
    private BeckGoodMapper beckGoodMapper;

    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public BeckGood selectBeckGoodById(String id)
    {
        return beckGoodMapper.selectBeckGoodById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param beckGood 商品
     * @return 商品
     */
    @Override
    public List<BeckGood> selectBeckGoodList(BeckGood beckGood)
    {
        beckGood.setDelFlag("0");
        return beckGoodMapper.selectBeckGoodList(beckGood);
    }

    /**
     * 新增商品
     * 
     * @param beckGood 商品
     * @return 结果
     */
    @Override
    public int insertBeckGood(BeckGood beckGood)
    {
        beckGood.setCreateTime(DateUtils.getNowDate());
        beckGood.setDelFlag("0");
        return beckGoodMapper.insertBeckGood(beckGood);
    }

    /**
     * 修改商品
     * 
     * @param beckGood 商品
     * @return 结果
     */
    @Override
    public int updateBeckGood(BeckGood beckGood)
    {
        beckGood.setUpdateTime(DateUtils.getNowDate());
        return beckGoodMapper.updateBeckGood(beckGood);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteBeckGoodByIds(String[] ids)
    {
        return beckGoodMapper.deleteByLogicBeckGoodByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteBeckGoodById(String id)
    {
        return beckGoodMapper.deleteByLogicBeckGoodById(id);
    }
}
