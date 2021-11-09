package com.beck.customer.service;

import java.util.List;
import com.beck.customer.domain.BeckCustomer;

/**
 * 用户Service接口
 * 
 * @author beck
 * @date 2021-10-20
 */
public interface IBeckCustomerService 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public BeckCustomer selectBeckCustomerById(String id);

    /**
     * 查询用户
     *
     * @param openid 微信用户标识
     * @return 用户
     */
    public BeckCustomer selectBeckCustomerByOpenId(String openid);

    /**
     * 查询用户列表
     * 
     * @param beckCustomer 用户
     * @return 用户集合
     */
    public List<BeckCustomer> selectBeckCustomerList(BeckCustomer beckCustomer);

    /**
     * 新增用户
     * 
     * @param beckCustomer 用户
     * @return 结果
     */
    public int insertBeckCustomer(BeckCustomer beckCustomer);

    /**
     * 修改用户
     * 
     * @param beckCustomer 用户
     * @return 结果
     */
    public int updateBeckCustomer(BeckCustomer beckCustomer);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    public int deleteBeckCustomerByIds(String[] ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteBeckCustomerById(String id);
}
