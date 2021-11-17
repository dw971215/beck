package com.beck.web.controller.business;

import java.util.List;

import com.beck.common.utils.sign.Md5Utils;
import com.beck.common.utils.uuid.UUID;
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
import com.beck.customer.domain.BeckCustomer;
import com.beck.customer.service.IBeckCustomerService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 会员用户Controller
 * 
 * @author beck
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/business/customer")
public class BeckCustomerController extends BaseController
{
    @Autowired
    private IBeckCustomerService beckCustomerService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckCustomer beckCustomer)
    {
        startPage();
        List<BeckCustomer> list = beckCustomerService.selectBeckCustomerList(beckCustomer);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:customer:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckCustomer beckCustomer)
    {
        List<BeckCustomer> list = beckCustomerService.selectBeckCustomerList(beckCustomer);
        ExcelUtil<BeckCustomer> util = new ExcelUtil<BeckCustomer>(BeckCustomer.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:customer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckCustomerService.selectBeckCustomerById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('business:customer:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckCustomer beckCustomer)
    {
        return toAjax(beckCustomerService.insertBeckCustomer(beckCustomer));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('business:customer:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckCustomer beckCustomer)
    {
        return toAjax(beckCustomerService.updateBeckCustomer(beckCustomer));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('business:customer:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckCustomerService.deleteBeckCustomerByIds(ids));
    }
}
