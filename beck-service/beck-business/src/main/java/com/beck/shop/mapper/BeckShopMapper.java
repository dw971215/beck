package com.beck.shop.mapper;

import com.beck.shop.domain.BeckShop;

import java.util.List;

/**
 * 商户门店Mapper接口
 * 
 * @author beck
 * @date 2021-11-10
 */
public interface BeckShopMapper 
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
     * 删除商户门店
     * 
     * @param id 商户门店ID
     * @return 结果
     */
    public int deleteBeckShopById(String id);

    /**
     * 批量删除商户门店
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeckShopByIds(String[] ids);

    /**
     * 逻辑删除单条记录
     * @param id
     * @return
     */
    public int deleteByLogicById(String id);

    /**
     * 逻辑删除多条记录
     * @param ids
     * @return
     */
    public int deleteByLogicByIds(String[] ids);
}
