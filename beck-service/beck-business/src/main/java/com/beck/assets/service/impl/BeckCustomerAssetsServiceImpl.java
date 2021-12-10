package com.beck.assets.service.impl;

import java.util.List;

import com.beck.common.utils.DateUtils;
import com.beck.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beck.assets.mapper.BeckCustomerAssetsMapper;
import com.beck.assets.domain.BeckCustomerAssets;
import com.beck.assets.service.IBeckCustomerAssetsService;

/**
 * 用户资产Service业务层处理
 * 
 * @author beck
 * @date 2021-11-11
 */
@Service
public class BeckCustomerAssetsServiceImpl implements IBeckCustomerAssetsService 
{
    @Autowired
    private BeckCustomerAssetsMapper beckCustomerAssetsMapper;

    /**
     * 查询用户资产
     * 
     * @param id 用户资产ID
     * @return 用户资产
     */
    @Override
    public BeckCustomerAssets selectBeckCustomerAssetsById(String id)
    {
        return beckCustomerAssetsMapper.selectBeckCustomerAssetsById(id);
    }

    /**
     * 查询用户资产列表
     * 
     * @param beckCustomerAssets 用户资产
     * @return 用户资产
     */
    @Override
    public List<BeckCustomerAssets> selectBeckCustomerAssetsList(BeckCustomerAssets beckCustomerAssets)
    {
        beckCustomerAssets.setDelFlag("0");
        return beckCustomerAssetsMapper.selectBeckCustomerAssetsList(beckCustomerAssets);
    }

    /**
     * 新增用户资产
     * 
     * @param beckCustomerAssets 用户资产
     * @return 结果
     */
    @Override
    public int insertBeckCustomerAssets(BeckCustomerAssets beckCustomerAssets)
    {
        beckCustomerAssets.setCreateTime(DateUtils.getNowDate());
        beckCustomerAssets.setDelFlag("0");
        return beckCustomerAssetsMapper.insertBeckCustomerAssets(beckCustomerAssets);
    }

    /**
     * 修改用户资产
     * 
     * @param beckCustomerAssets 用户资产
     * @return 结果
     */
    @Override
    public int updateBeckCustomerAssets(BeckCustomerAssets beckCustomerAssets)
    {
        beckCustomerAssets.setUpdateTime(DateUtils.getNowDate());
        return beckCustomerAssetsMapper.updateBeckCustomerAssets(beckCustomerAssets);
    }

    /**
     * 批量删除用户资产
     * 
     * @param ids 需要删除的用户资产ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerAssetsByIds(String[] ids)
    {
        return beckCustomerAssetsMapper.deleteByLogicByIds(ids);
    }

    /**
     * 删除用户资产信息
     * 
     * @param id 用户资产ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerAssetsById(String id)
    {
        return beckCustomerAssetsMapper.deleteByLogicById(id);
    }
}
