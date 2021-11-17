package com.beck.shop.service.impl;

import java.util.List;
import com.beck.common.utils.DateUtils;
import com.beck.common.utils.uuid.UUID;
import com.beck.shop.domain.BeckShop;
import com.beck.shop.mapper.BeckShopMapper;
import com.beck.shop.service.IBeckShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商户门店Service业务层处理
 * 
 * @author beck
 * @date 2021-11-10
 */
@Service
public class BeckShopServiceImpl implements IBeckShopService
{
    @Autowired
    private BeckShopMapper beckShopMapper;

    /**
     * 查询商户门店
     * 
     * @param id 商户门店ID
     * @return 商户门店
     */
    @Override
    public BeckShop selectBeckShopById(String id)
    {
        return beckShopMapper.selectBeckShopById(id);
    }

    /**
     * 查询商户门店列表
     * 
     * @param beckShop 商户门店
     * @return 商户门店
     */
    @Override
    public List<BeckShop> selectBeckShopList(BeckShop beckShop)
    {
        beckShop.setDelFlag("0");
        return beckShopMapper.selectBeckShopList(beckShop);
    }

    /**
     * 新增商户门店
     * 
     * @param beckShop 商户门店
     * @return 结果
     */
    @Override
    public int insertBeckShop(BeckShop beckShop)
    {
        beckShop.setCreateTime(DateUtils.getNowDate());
        beckShop.setId(UUID.randomUUID().toString());
        beckShop.setDelFlag("0");
        return beckShopMapper.insertBeckShop(beckShop);
    }

    /**
     * 修改商户门店
     * 
     * @param beckShop 商户门店
     * @return 结果
     */
    @Override
    public int updateBeckShop(BeckShop beckShop)
    {
        beckShop.setUpdateTime(DateUtils.getNowDate());
        return beckShopMapper.updateBeckShop(beckShop);
    }

    /**
     * 批量删除商户门店
     * 
     * @param ids 需要删除的商户门店ID
     * @return 结果
     */
    @Override
    public int deleteBeckShopByIds(String[] ids)
    {
        return beckShopMapper.deleteByLogicByIds(ids);
    }

    /**
     * 删除商户门店信息
     * 
     * @param id 商户门店ID
     * @return 结果
     */
    @Override
    public int deleteBeckShopById(String id)
    {
        return beckShopMapper.deleteByLogicById(id);
    }
}
