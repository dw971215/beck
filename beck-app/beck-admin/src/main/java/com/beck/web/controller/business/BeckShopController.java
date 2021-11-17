package com.beck.web.controller.business;

import java.util.List;

import com.beck.common.utils.poi.ExcelUtil;
import com.beck.shop.domain.BeckShop;
import com.beck.shop.service.IBeckShopService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beck.common.annotation.Log;
import com.beck.common.core.controller.BaseController;
import com.beck.common.core.domain.AjaxResult;
import com.beck.common.enums.BusinessType;
import com.beck.common.core.page.TableDataInfo;

/**
 * 商户门店Controller
 * 
 * @author beck
 * @date 2021-11-10
 */
@RestController
@RequestMapping("/business/shop")
public class BeckShopController extends BaseController
{
    @Autowired
    private IBeckShopService beckShopService;

    /**
     * 查询商户门店列表
     */
    @PreAuthorize("@ss.hasPermi('business:shop:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckShop beckShop)
    {
        startPage();
        List<BeckShop> list = beckShopService.selectBeckShopList(beckShop);
        return getDataTable(list);
    }

    /**
     * 导出商户门店列表
     */
    @PreAuthorize("@ss.hasPermi('business:shop:export')")
    @Log(title = "商户门店", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckShop beckShop)
    {
        List<BeckShop> list = beckShopService.selectBeckShopList(beckShop);
        ExcelUtil<BeckShop> util = new ExcelUtil<BeckShop>(BeckShop.class);
        return util.exportExcel(list, "商户门店数据");
    }

    /**
     * 获取商户门店详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:shop:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckShopService.selectBeckShopById(id));
    }

    /**
     * 新增商户门店
     */
    @PreAuthorize("@ss.hasPermi('business:shop:add')")
    @Log(title = "商户门店", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckShop beckShop)
    {
        return toAjax(beckShopService.insertBeckShop(beckShop));
    }

    /**
     * 修改商户门店
     */
    @PreAuthorize("@ss.hasPermi('business:shop:edit')")
    @Log(title = "商户门店", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckShop beckShop)
    {
        return toAjax(beckShopService.updateBeckShop(beckShop));
    }

    /**
     * 删除商户门店
     */
    @PreAuthorize("@ss.hasPermi('business:shop:remove')")
    @Log(title = "商户门店", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckShopService.deleteBeckShopByIds(ids));
    }
}
