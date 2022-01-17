package com.beck.web.controller.business;

import java.util.List;

import com.beck.common.utils.StringUtils;
import com.beck.common.utils.uuid.UUID;
import com.beck.good.category.domain.BeckGoodCategory;
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
import com.beck.good.goods.domain.BeckGood;
import com.beck.good.goods.service.IBeckGoodService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author beck
 * @date 2021-12-31
 */
@RestController
@RequestMapping("/business/good")
public class BeckGoodController extends BaseController
{
    @Autowired
    private IBeckGoodService beckGoodService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('business:good:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckGood beckGood)
    {
        startPage();
        if (StringUtils.isNotNull(beckGood.getParams().get("categoryId"))){
            beckGood.setGoodCategory(new BeckGoodCategory(beckGood.getParams().get("categoryId").toString()));
        }
        List<BeckGood> list = beckGoodService.selectBeckGoodList(beckGood);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('business:good:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckGood beckGood)
    {
        List<BeckGood> list = beckGoodService.selectBeckGoodList(beckGood);
        ExcelUtil<BeckGood> util = new ExcelUtil<BeckGood>(BeckGood.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:good:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckGoodService.selectBeckGoodById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('business:good:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckGood beckGood)
    {
        beckGood.setId(UUID.randomUUID().toString());
        return toAjax(beckGoodService.insertBeckGood(beckGood));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('business:good:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckGood beckGood)
    {
        return toAjax(beckGoodService.updateBeckGood(beckGood));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('business:good:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckGoodService.deleteBeckGoodByIds(ids));
    }
}
