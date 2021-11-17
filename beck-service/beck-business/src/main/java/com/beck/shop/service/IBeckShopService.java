package com.beck.shop.service;

import com.beck.shop.domain.BeckShop;

import java.util.List;

/**
 * 商户门店Service接口
 * 
 * @author beck
 * @date 2021-11-10
 */
public interface IBeckShopService 
{
    /**
     * 查询商户门店
     * 
     * @param id 商户门店ID
     * @return 商户门店
     */
    public BeckShop selectBeckShopById(String id);

    /**
     * 查询商户门店列表
     * 
     * @param beckShop 商户门店
     * @return 商户门店集合
     */
    public List<BeckShop> selectBeckShopList(BeckShop beckShop);

    /**
     * 新增商户门店
     * 
     * @param beckShop 商户门店
     * @return 结果
     */
    public int insertBeckShop(BeckShop beckShop);

    /**
     * 修改商户门店
     * 
     * @param beckShop 商户门店
     * @return 结果
     */
    public int updateBeckShop(BeckShop beckShop);

    /**
     * 批量删除商户门店
     * 
     * @param ids 需要删除的商户门店ID
     * @return 结果
     */
    public int deleteBeckShopByIds(String[] ids);

    /**
     * 删除商户门店信息
     * 
     * @param id 商户门店ID
     * @return 结果
     */
    public int deleteBeckShopById(String id);
}
