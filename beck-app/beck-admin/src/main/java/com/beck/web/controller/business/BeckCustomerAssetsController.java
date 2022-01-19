package com.beck.web.controller.business;

import java.util.List;

import com.beck.common.utils.StringUtils;
import com.beck.common.utils.uuid.UUID;
import com.beck.user.customer.domain.BeckCustomer;
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
import com.beck.user.assets.domain.BeckCustomerAssets;
import com.beck.user.assets.service.IBeckCustomerAssetsService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 用户资产Controller
 * 
 * @author beck
 * @date 2021-11-11
 */
@RestController
@RequestMapping("/business/assets")
public class BeckCustomerAssetsController extends BaseController
{
    @Autowired
    private IBeckCustomerAssetsService beckCustomerAssetsService;

    /**
     * 查询用户资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:assets:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckCustomerAssets beckCustomerAssets)
    {
        startPage();
        String nickName = beckCustomerAssets.getParams().get("nickName").toString();
        if (StringUtils.isNotNull(nickName)){
            BeckCustomer beckCustomer = new BeckCustomer();
            beckCustomer.setNickName(nickName);
            beckCustomerAssets.setUser(beckCustomer);
        }
        List<BeckCustomerAssets> list = beckCustomerAssetsService.selectBeckCustomerAssetsList(beckCustomerAssets);
        return getDataTable(list);
    }

    /**
     * 导出用户资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:assets:export')")
    @Log(title = "用户资产", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckCustomerAssets beckCustomerAssets)
    {
        List<BeckCustomerAssets> list = beckCustomerAssetsService.selectBeckCustomerAssetsList(beckCustomerAssets);
        ExcelUtil<BeckCustomerAssets> util = new ExcelUtil<BeckCustomerAssets>(BeckCustomerAssets.class);
        return util.exportExcel(list, "用户资产数据");
    }

    /**
     * 获取用户资产详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:assets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckCustomerAssetsService.selectBeckCustomerAssetsById(id));
    }

    /**
     * 新增用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:assets:add')")
    @Log(title = "用户资产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckCustomerAssets beckCustomerAssets)
    {
        beckCustomerAssets.setId(UUID.randomUUID().toString());
        return toAjax(beckCustomerAssetsService.insertBeckCustomerAssets(beckCustomerAssets));
    }

    /**
     * 修改用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:assets:edit')")
    @Log(title = "用户资产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckCustomerAssets beckCustomerAssets)
    {
        return toAjax(beckCustomerAssetsService.updateBeckCustomerAssets(beckCustomerAssets));
    }

    /**
     * 删除用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:assets:remove')")
    @Log(title = "用户资产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckCustomerAssetsService.deleteBeckCustomerAssetsByIds(ids));
    }
}
