package com.beck.web.controller.business;

import java.util.List;

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
import com.beck.good.category.domain.BeckGoodCategory;
import com.beck.good.category.service.IBeckGoodCategoryService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author beck
 * @date 2021-12-10
 */
@RestController
@RequestMapping("/business/category")
public class BeckGoodCategoryController extends BaseController
{
    @Autowired
    private IBeckGoodCategoryService beckGoodCategoryService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckGoodCategory beckGoodCategory)
    {
        startPage();
        List<BeckGoodCategory> list = beckGoodCategoryService.selectBeckGoodCategoryList(beckGoodCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:category:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckGoodCategory beckGoodCategory)
    {
        List<BeckGoodCategory> list = beckGoodCategoryService.selectBeckGoodCategoryList(beckGoodCategory);
        ExcelUtil<BeckGoodCategory> util = new ExcelUtil<BeckGoodCategory>(BeckGoodCategory.class);
        return util.exportExcel(list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckGoodCategoryService.selectBeckGoodCategoryById(id));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:category:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckGoodCategory beckGoodCategory)
    {
        beckGoodCategory.setId(UUID.randomUUID().toString());
        return toAjax(beckGoodCategoryService.insertBeckGoodCategory(beckGoodCategory));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:category:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckGoodCategory beckGoodCategory)
    {
        return toAjax(beckGoodCategoryService.updateBeckGoodCategory(beckGoodCategory));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:category:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckGoodCategoryService.deleteBeckGoodCategoryByIds(ids));
    }
}
