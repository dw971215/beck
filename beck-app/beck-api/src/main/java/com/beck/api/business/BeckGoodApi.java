package com.beck.api.business;

import com.beck.common.core.domain.AjaxResult;
import com.beck.good.category.domain.BeckGoodCategory;
import com.beck.good.category.service.IBeckGoodCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api("商品信息管理")
@RestController
@RequestMapping(value = "${apiPath}/goodCategory")
public class BeckGoodApi {

    @Autowired
    private IBeckGoodCategoryService categoryService;

    @ApiOperation("获取商品分类以及商品")
    @GetMapping("/goodInfo")
    public AjaxResult goodInfo() {
        List<BeckGoodCategory> beckGoodCategories = categoryService.selectBeckGoodCategoryListNew(new BeckGoodCategory());
        return AjaxResult.success(beckGoodCategories);
    }
}
