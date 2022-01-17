package com.beck.good.goods.service;

import java.util.List;
import com.beck.good.goods.domain.BeckGood;

/**
 * 商品Service接口
 * 
 * @author beck
 * @date 2021-12-31
 */
public interface IBeckGoodService 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public BeckGood selectBeckGoodById(String id);

    /**
     * 查询商品列表
     * 
     * @param beckGood 商品
     * @return 商品集合
     */
    public List<BeckGood> selectBeckGoodList(BeckGood beckGood);

    /**
     * 新增商品
     * 
     * @param beckGood 商品
     * @return 结果
     */
    public int insertBeckGood(BeckGood beckGood);

    /**
     * 修改商品
     * 
     * @param beckGood 商品
     * @return 结果
     */
    public int updateBeckGood(BeckGood beckGood);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品ID
     * @return 结果
     */
    public int deleteBeckGoodByIds(String[] ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteBeckGoodById(String id);
}
