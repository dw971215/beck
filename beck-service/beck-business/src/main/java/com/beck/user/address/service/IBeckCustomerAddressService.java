package com.beck.user.address.service;

import java.util.List;
import com.beck.user.address.domain.BeckCustomerAddress;

/**
 * 收货地址Service接口
 * 
 * @author beck
 * @date 2021-11-22
 */
public interface IBeckCustomerAddressService 
{
    /**
     * 查询收货地址
     * 
     * @param id 收货地址ID
     * @return 收货地址
     */
    public BeckCustomerAddress selectBeckCustomerAddressById(String id);

    /**
     * 查询收货地址列表
     * 
     * @param beckCustomerAddress 收货地址
     * @return 收货地址集合
     */
    public List<BeckCustomerAddress> selectBeckCustomerAddressList(BeckCustomerAddress beckCustomerAddress);

    /**
     * 新增收货地址
     * 
     * @param beckCustomerAddress 收货地址
     * @return 结果
     */
    public int insertBeckCustomerAddress(BeckCustomerAddress beckCustomerAddress);

    /**
     * 修改收货地址
     * 
     * @param beckCustomerAddress 收货地址
     * @return 结果
     */
    public int updateBeckCustomerAddress(BeckCustomerAddress beckCustomerAddress);

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的收货地址ID
     * @return 结果
     */
    public int deleteBeckCustomerAddressByIds(String[] ids);

    /**
     * 删除收货地址信息
     * 
     * @param id 收货地址ID
     * @return 结果
     */
    public int deleteBeckCustomerAddressById(String id);
}
