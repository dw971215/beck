package com.beck.api.test;

import com.beck.common.core.domain.AjaxResult;
import com.beck.common.filter.word.FileTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping(value = "/api/test")
public class TestApi {

    /**
     * 添加敏感词
     * @return
     */
    @ApiOperation("添加敏感词")
    @GetMapping("/add")
    public AjaxResult add(@ApiParam(name = "str", value = "敏感词") String str) {
        if(str.isEmpty()){
            return AjaxResult.error("敏感词为空");
        }
        String file_path = getClass().getResource("/wd.txt").getPath();
        FileTools.string2FileLast(str,file_path);
        return AjaxResult.success("添加成功");
    }

    /**
     * 删除敏感词
     * @return
     */
    @ApiOperation("删除敏感词")
    @GetMapping("/delete")
    public AjaxResult delete(@ApiParam(name = "str", value = "敏感词") String str) {
        if(str.isEmpty()){
            return AjaxResult.error("敏感词为空");
        }
        String file_path = getClass().getResource("/wd.txt").getPath();
        FileTools.replaceFileContent(str,"",file_path);
        return AjaxResult.success("删除成功");
    }
}
