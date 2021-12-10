package com.beck.api.business;

import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.DateUtils;
import com.beck.common.utils.StringUtils;
import com.beck.customer.domain.BeckCustomer;
import com.beck.customer.service.IBeckCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户信息管理")
@RestController
@RequestMapping(value = "${apiPath}/customer")
public class BeckCustomerApi {

    @Autowired
    private IBeckCustomerService customerService;

    @ApiOperation("获取用户信息")
    @GetMapping(value = "getUserInfo")
    public AjaxResult getUserInfo(@ApiParam(name = "userId",value = "用户id",required = true) String userId){
        if(StringUtils.isBlank(userId)){
            return AjaxResult.error("用户id为空");
        }
        BeckCustomer beckCustomer = customerService.selectBeckCustomerById(userId);
        return AjaxResult.success("获取成功",beckCustomer);
    }

    @ApiOperation("修改用户消息")
    @GetMapping(value = "/updateUserInfo")
    public AjaxResult updateUserInfo(@ApiParam(name = "userId",value = "用户id",required = true) String userId,
                                     @ApiParam(name = "mobile",value = "手机号码",required = false) String mobile,
                                     @ApiParam(name = "gender",value = "性别",required = true) String gender,
                                     @ApiParam(name = "realName",value = "真实姓名",required = false) String realName,
                                     @ApiParam(name = "birthday",value = "生日",required = false) String birthday) throws Exception{

        if(StringUtils.isBlank(userId)){
            return AjaxResult.error("userId为空");
        }
        BeckCustomer res = customerService.selectBeckCustomerById(userId);
        if(res == null ){
            return AjaxResult.error("用户不存在");
        }
        BeckCustomer beckCustomer = new BeckCustomer();
        beckCustomer.setId(userId);
        beckCustomer.setMobile(mobile);
        beckCustomer.setGender(gender);
        beckCustomer.setRealName(realName);
        beckCustomer.setBirthday(DateUtils.parseDate(birthday,"yyyy-MM-dd"));
        int i = customerService.updateBeckCustomer(beckCustomer);
        if(i==0){
            return AjaxResult.success("修改失败");
        }
        return AjaxResult.success("修改成功");
    }
}