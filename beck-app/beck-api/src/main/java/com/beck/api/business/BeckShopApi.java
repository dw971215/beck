package com.beck.api.business;

import com.beck.common.core.domain.AjaxResult;
import com.beck.shop.domain.BeckShop;
import com.beck.shop.service.IBeckShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@Api("门店信息管理")
@RestController
@RequestMapping(value = "${apiPath}/shop")
public class BeckShopApi {

    @Autowired
    private IBeckShopService shopService;

    @ApiOperation("获取门店信息")
    @GetMapping("/shopInfo")
    public AjaxResult shopInfo()
    {
        BeckShop shop = new BeckShop();
        List<BeckShop> beckShops = new ArrayList<BeckShop>();
        beckShops = shopService.selectBeckShopList(shop);
        if(beckShops.isEmpty()){
         return AjaxResult.error("门店信息不存在");
        }
        return AjaxResult.success(beckShops.get(0));
    }
}
