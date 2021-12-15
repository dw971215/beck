package com.beck.api.business;

import com.beck.address.domain.BeckCustomerAddress;
import com.beck.address.service.IBeckCustomerAddressService;
import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.StringUtils;
import com.beck.common.utils.uuid.UUID;
import com.beck.customer.domain.BeckCustomer;
import com.beck.customer.service.IBeckCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api("用户地址管理")
@RestController
@RequestMapping(value = "${apiPath}/customerAddress")
public class BeckCustomerAddressApi {

    @Autowired
    private IBeckCustomerService customerService;

    @Autowired
    private IBeckCustomerAddressService beckCustomerAddressService;

    @ApiOperation("获取地址信息")
    @GetMapping("/list")
    public AjaxResult list(@ApiParam(name = "userId", value = "用户id", required = true) String userId)
    {
        if (StringUtils.isBlank(userId)) {
            return AjaxResult.error("用户id为空");
        }
        BeckCustomerAddress beckCustomerAddress = new BeckCustomerAddress();
        beckCustomerAddress.setUser(new BeckCustomer(userId));
        List<BeckCustomerAddress> beckCustomerAddresses = new ArrayList<>();
        beckCustomerAddresses = beckCustomerAddressService.selectBeckCustomerAddressList(beckCustomerAddress);
        return AjaxResult.success(beckCustomerAddresses);
    }

    @ApiOperation("新增/修改地址")
    @GetMapping(value = "/updateAddress")
    public AjaxResult updateUserInfo(@ApiParam(name = "userId",value = "用户id",required = true) String userId,
                                     @ApiParam(name = "id",value = "id",required = false) String id,
                                     @ApiParam(name = "mobile",value = "手机号码",required = true) String mobile,
                                     @ApiParam(name = "sex",value = "性别",required = true) String sex,
                                     @ApiParam(name = "address",value = "地址",required = true) String address,
                                     @ApiParam(name = "doorNumber",value = "门牌号",required = true) String doorNumber,
                                     @ApiParam(name = "name",value = "姓名",required = true) String name) throws Exception{

        if(StringUtils.isBlank(userId)){
            return AjaxResult.error("userId为空");
        }
        BeckCustomer res = customerService.selectBeckCustomerById(userId);
        if(res == null ){
            return AjaxResult.error("用户不存在");
        }
        BeckCustomerAddress beckCustomerAddress = new BeckCustomerAddress();
        beckCustomerAddress.setAddress(address);
        beckCustomerAddress.setDoorNumber(doorNumber);
        beckCustomerAddress.setName(name);
        beckCustomerAddress.setMobile(mobile);
        beckCustomerAddress.setSex(sex);
        int i = 0;
        if(StringUtils.isBlank(id)){
            beckCustomerAddress.setId(UUID.randomUUID().toString());
            beckCustomerAddress.setUser(new BeckCustomer(userId));
            i = beckCustomerAddressService.insertBeckCustomerAddress(beckCustomerAddress);
            if(i==0){
                return AjaxResult.success("添加失败");
            }
            return AjaxResult.success("添加成功",beckCustomerAddress);
        }else{
            beckCustomerAddress.setId(id);
            i = beckCustomerAddressService.updateBeckCustomerAddress(beckCustomerAddress);
        }
        if(i==0){
            return AjaxResult.success("修改失败");
        }
        return AjaxResult.success("修改成功");
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @ApiOperation("删除地址信息")
    @GetMapping("/delete")
    public AjaxResult delete(@ApiParam(name = "id", value = "地址信息id", required = true) String id)
    {
        if (StringUtils.isBlank(id)) {
            return AjaxResult.error("id为空");
        }
        int i = beckCustomerAddressService.deleteBeckCustomerAddressById(id);
        if(i==0){
            return AjaxResult.error("删除失败");
        }
        return AjaxResult.success("删除成功");
    }

}
