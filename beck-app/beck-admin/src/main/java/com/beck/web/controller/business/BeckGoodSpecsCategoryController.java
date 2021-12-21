package com.beck.web.controller.business;

import java.util.List;

import com.beck.common.utils.uuid.UUID;
import com.beck.good.specs.domain.BeckGoodSpecsProperty;
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
import com.beck.good.specs.domain.BeckGoodSpecsCategory;
import com.beck.good.specs.service.IBeckGoodSpecsCategoryService;
import com.beck.common.utils.poi.ExcelUtil;
import com.beck.common.core.page.TableDataInfo;

/**
 * 商品规格分类Controller
 * 
 * @author beck
 * @date 2021-12-10
 */
@RestController
@RequestMapping("/business/specs")
public class BeckGoodSpecsCategoryController extends BaseController
{
    @Autowired
    private IBeckGoodSpecsCategoryService beckGoodSpecsCategoryService;

    /**
     * 查询商品规格分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:specs:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        startPage();
        List<BeckGoodSpecsCategory> list = beckGoodSpecsCategoryService.selectBeckGoodSpecsCategoryList(beckGoodSpecsCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品规格分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:specs:export')")
    @Log(title = "商品规格分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        List<BeckGoodSpecsCategory> list = beckGoodSpecsCategoryService.selectBeckGoodSpecsCategoryList(beckGoodSpecsCategory);
        ExcelUtil<BeckGoodSpecsCategory> util = new ExcelUtil<BeckGoodSpecsCategory>(BeckGoodSpecsCategory.class);
        return util.exportExcel(list, "商品规格分类数据");
    }

    /**
     * 获取商品规格分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:specs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(beckGoodSpecsCategoryService.selectBeckGoodSpecsCategoryById(id));
    }

    /**
     * 新增商品规格分类
     */
    @PreAuthorize("@ss.hasPermi('business:specs:add')")
    @Log(title = "商品规格分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        beckGoodSpecsCategory.setId(UUID.randomUUID().toString());
        return toAjax(beckGoodSpecsCategoryService.insertBeckGoodSpecsCategory(beckGoodSpecsCategory));
    }

    /**
     * 修改商品规格分类
     */
    @PreAuthorize("@ss.hasPermi('business:specs:edit')")
    @Log(title = "商品规格分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeckGoodSpecsCategory beckGoodSpecsCategory)
    {
        return toAjax(beckGoodSpecsCategoryService.updateBeckGoodSpecsCategory(beckGoodSpecsCategory));
    }

    /**
     * 删除商品规格分类
     */
    @PreAuthorize("@ss.hasPermi('business:specs:remove')")
    @Log(title = "商品规格分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(beckGoodSpecsCategoryService.deleteBeckGoodSpecsCategoryByIds(ids));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('business:specs:edit')")
    @Log(title = "商品规格属性修改", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody BeckGoodSpecsProperty beckGoodSpecsProperty)
    {

        return toAjax(beckGoodSpecsCategoryService.changeStatus(beckGoodSpecsProperty));
    }
}
