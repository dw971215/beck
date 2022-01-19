package com.beck.web.controller.business;

import java.util.List;
import java.util.UUID;

import com.beck.common.utils.StringUtils;
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
import com.beck.user.address.domain.BeckCustomerAddress;
import com.beck.user.address.service.IBeckCustomerAddressService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 收货地址Controller
 * 
 * @author beck
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/business/address")
public class BeckCustomerAddressController extends BaseController
{
    @Autowired
    private IBeckCustomerAddressService beckCustomerAddressService;

    /**
     * 查询收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('business:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckCustomerAddress beckCustomerAddress)
    {
        startPage();
        if (StringUtils.isNotNull(beckCustomerAddress.getParams().get("userId"))){
            beckCustomerAddress.setUser(new BeckCustomer(beckCustomerAddress.getParams().get("userId").toString()));
        }
        List<BeckCustomerAddress> list = beckCustomerAddressService.selectBeckCustomerAddressList(beckCustomerAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('business:address:export')")
    @Log(title = "收货地址", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckCustomerAddress beckCustomerAddress)
    {
        List<BeckCustomerAddress> list = beckCustomerAddressService.selectBeckCustomerAddressList(beckCustomerAddress);
        ExcelUtil<BeckCustomerAddress> util = new ExcelUtil<BeckCustomerAddress>(BeckCustomerAddress.class);
        return util.exportExcel(list, "收货地址数据");
    }

    /**
     * 获取收货地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:address:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckCustomerAddressService.selectBeckCustomerAddressById(id));
    }

    /**
     * 新增收货地址
     */
    @PreAuthorize("@ss.hasPermi('business:address:add')")
    @Log(title = "收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckCustomerAddress beckCustomerAddress)
    {
        beckCustomerAddress.setId(UUID.randomUUID().toString());
        return toAjax(beckCustomerAddressService.insertBeckCustomerAddress(beckCustomerAddress));
    }

    /**
     * 修改收货地址
     */
    @PreAuthorize("@ss.hasPermi('business:address:edit')")
    @Log(title = "收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckCustomerAddress beckCustomerAddress)
    {
        return toAjax(beckCustomerAddressService.updateBeckCustomerAddress(beckCustomerAddress));
    }

    /**
     * 删除收货地址
     */
    @PreAuthorize("@ss.hasPermi('business:address:remove')")
    @Log(title = "收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckCustomerAddressService.deleteBeckCustomerAddressByIds(ids));
    }
}
