package com.beck.assets.service;

import java.util.List;
import com.beck.assets.domain.BeckCustomerAssets;

/**
 * 用户资产Service接口
 * 
 * @author beck
 * @date 2021-11-11
 */
public interface IBeckCustomerAssetsService 
{
    /**
     * 查询用户资产
     * 
     * @param id 用户资产ID
     * @return 用户资产
     */
    public BeckCustomerAssets selectBeckCustomerAssetsById(String id);

    /**
     * 查询用户资产列表
     * 
     * @param beckCustomerAssets 用户资产
     * @return 用户资产集合
     */
    public List<BeckCustomerAssets> selectBeckCustomerAssetsList(BeckCustomerAssets beckCustomerAssets);

    /**
     * 新增用户资产
     * 
     * @param beckCustomerAssets 用户资产
     * @return 结果
     */
    public int insertBeckCustomerAssets(BeckCustomerAssets beckCustomerAssets);

    /**
     * 修改用户资产
     * 
     * @param beckCustomerAssets 用户资产
     * @return 结果
     */
    public int updateBeckCustomerAssets(BeckCustomerAssets beckCustomerAssets);

    /**
     * 批量删除用户资产
     * 
     * @param ids 需要删除的用户资产ID
     * @return 结果
     */
    public int deleteBeckCustomerAssetsByIds(String[] ids);

    /**
     * 删除用户资产信息
     * 
     * @param id 用户资产ID
     * @return 结果
     */
    public int deleteBeckCustomerAssetsById(String id);
}
