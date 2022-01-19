package com.beck.user.assets.mapper;

import java.util.List;
import com.beck.user.assets.domain.BeckCustomerAssets;

/**
 * 用户资产Mapper接口
 * 
 * @author beck
 * @date 2021-11-11
 */
public interface BeckCustomerAssetsMapper 
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
     * 删除用户资产
     * 
     * @param id 用户资产ID
     * @return 结果
     */
    public int deleteBeckCustomerAssetsById(String id);

    /**
     * 批量删除用户资产
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeckCustomerAssetsByIds(String[] ids);

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

    /**
     * 根据用户id删除资产信息
     * @param userId
     * @return
     */
    public int deleteBeckCustomerAssetsByUserId(String userId);

    /**
     * 根据多个用户id删除资产信息
     * @param ids
     * @return
     */
    public int deleteBeckCustomerAssetsByUserIds(String[] ids);
}
