package com.beck.user.address.mapper;

import java.util.List;
import com.beck.user.address.domain.BeckCustomerAddress;

/**
 * 收货地址Mapper接口
 * 
 * @author beck
 * @date 2021-11-22
 */
public interface BeckCustomerAddressMapper 
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
     * 删除收货地址
     * 
     * @param id 收货地址ID
     * @return 结果
     */
    public int deleteBeckCustomerAddressById(String id);

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeckCustomerAddressByIds(String[] ids);
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
     * 根据用户id删除地址信息
     * @param userId
     * @return
     */
    public int deleteBeckCustomerAddressByUserId(String userId);

    /**
     * 根据多个用户id删除地址信息
     * @param ids
     * @return
     */
    public int deleteBeckCustomerAddressByUserIds(String[] ids);
}
