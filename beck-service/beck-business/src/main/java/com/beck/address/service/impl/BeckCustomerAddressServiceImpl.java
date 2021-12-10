package com.beck.address.service.impl;

import java.util.List;
import com.beck.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beck.address.mapper.BeckCustomerAddressMapper;
import com.beck.address.domain.BeckCustomerAddress;
import com.beck.address.service.IBeckCustomerAddressService;

/**
 * 收货地址Service业务层处理
 * 
 * @author beck
 * @date 2021-11-22
 */
@Service
public class BeckCustomerAddressServiceImpl implements IBeckCustomerAddressService 
{
    @Autowired
    private BeckCustomerAddressMapper beckCustomerAddressMapper;

    /**
     * 查询收货地址
     * 
     * @param id 收货地址ID
     * @return 收货地址
     */
    @Override
    public BeckCustomerAddress selectBeckCustomerAddressById(String id)
    {
        return beckCustomerAddressMapper.selectBeckCustomerAddressById(id);
    }

    /**
     * 查询收货地址列表
     * 
     * @param beckCustomerAddress 收货地址
     * @return 收货地址
     */
    @Override
    public List<BeckCustomerAddress> selectBeckCustomerAddressList(BeckCustomerAddress beckCustomerAddress)
    {
        beckCustomerAddress.setDelFlag("0");
        return beckCustomerAddressMapper.selectBeckCustomerAddressList(beckCustomerAddress);
    }

    /**
     * 新增收货地址
     * 
     * @param beckCustomerAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertBeckCustomerAddress(BeckCustomerAddress beckCustomerAddress)
    {
        beckCustomerAddress.setCreateTime(DateUtils.getNowDate());
        beckCustomerAddress.setDelFlag("0");
        return beckCustomerAddressMapper.insertBeckCustomerAddress(beckCustomerAddress);
    }

    /**
     * 修改收货地址
     * 
     * @param beckCustomerAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateBeckCustomerAddress(BeckCustomerAddress beckCustomerAddress)
    {
        beckCustomerAddress.setUpdateTime(DateUtils.getNowDate());
        return beckCustomerAddressMapper.updateBeckCustomerAddress(beckCustomerAddress);
    }

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的收货地址ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerAddressByIds(String[] ids)
    {
        return beckCustomerAddressMapper.deleteByLogicByIds(ids);
    }

    /**
     * 删除收货地址信息
     * 
     * @param id 收货地址ID
     * @return 结果
     */
    @Override
    public int deleteBeckCustomerAddressById(String id)
    {
        return beckCustomerAddressMapper.deleteByLogicById(id);
    }
}
