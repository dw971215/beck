package com.beck.customer.service.impl;

import java.util.List;

import com.beck.address.mapper.BeckCustomerAddressMapper;
import com.beck.assets.mapper.BeckCustomerAssetsMapper;
import com.beck.common.utils.DateUtils;
import com.beck.common.utils.sign.Md5Utils;
import com.beck.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beck.customer.mapper.BeckCustomerMapper;
import com.beck.customer.domain.BeckCustomer;
import com.beck.customer.service.IBeckCustomerService;

/**
 * 用户Service业务层处理
 * 
 * @author beck
 * @date 2021-10-20
 */
@Service
public class BeckCustomerServiceImpl implements IBeckCustomerService 
{
    @Autowired
    private BeckCustomerMapper beckCustomerMapper;

    @Autowired
    private BeckCustomerAddressMapper beckCustomerAddressMapper;

    @Autowired
    private BeckCustomerAssetsMapper beckCustomerAssetsMapper;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public BeckCustomer selectBeckCustomerById(String id)
    {
        return beckCustomerMapper.selectBeckCustomerById(id);
    }

    @Override
    public BeckCustomer selectBeckCustomerByOpenId(String openid) {
        return beckCustomerMapper.selectBeckCustomerByOpenId(openid);
    }

    /**
     * 查询用户列表
     * 
     * @param beckCustomer 用户
     * @return 用户
     */
    @Override
    public List<BeckCustomer> selectBeckCustomerList(BeckCustomer beckCustomer)
    {
        beckCustomer.setDelFlag("0");
        return beckCustomerMapper.selectBeckCustomerList(beckCustomer);
    }

    /**
     * 新增用户
     * 
     * @param beckCustomer 用户
     * @return 结果
     */
    @Override
    public int insertBeckCustomer(BeckCustomer beckCustomer)
    {
        beckCustomer.setCreateTime(DateUtils.getNowDate());
        beckCustomer.setId(UUID.randomUUID().toString());
        beckCustomer.setLoginPassword(Md5Utils.hash("111111"));
        return beckCustomerMapper.insertBeckCustomer(beckCustomer);
    }

    /**
     * 修改用户
     * 
     * @param beckCustomer 用户
     * @return 结果
     */
    @Override
    public int updateBeckCustomer(BeckCustomer beckCustomer)
    {
        beckCustomer.setUpdateTime(DateUtils.getNowDate());
        return beckCustomerMapper.updateBeckCustomer(beckCustomer);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerByIds(String[] ids)
    {
        beckCustomerAddressMapper.deleteBeckCustomerAddressByUserIds(ids);
        beckCustomerAssetsMapper.deleteBeckCustomerAssetsByUserIds(ids);
        return beckCustomerMapper.deleteByLogicByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerById(String id)
    {
        beckCustomerAddressMapper.deleteBeckCustomerAddressByUserId(id);
        beckCustomerAssetsMapper.deleteBeckCustomerAssetsByUserId(id);
        return beckCustomerMapper.deleteByLogicById(id);
    }
}
