package com.beck.api.test;

import com.beck.common.core.domain.AjaxResult;
import com.beck.serial.domain.LedSerailPortReceived;
import com.beck.serial.utils.SerialPortUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 串口通信控制层
 * @Author dawei
 * @Date 2021/6/9 11:41
 */
@Api
@RestController
@RequestMapping("/api/led")
public class SerialPortApi {


    /**
     * 关闭/打开蜂鸣器
     * @param cmd
     * @return
     */
    @ApiOperation("关闭/打开蜂鸣器")
    @GetMapping("/sendLedPortMsg")
    @ApiImplicitParam(name = "cmd", value = "命令", required = true, dataType = "String")
    public AjaxResult sendLedPortMsg(@ApiParam(name = "cmd", value = "命令") String cmd) {

        try {
            String status = SerialPortUtils.sendMsg(cmd,new LedSerailPortReceived());
            if(!"success".equals(status)){
                return AjaxResult.success("串口指令发送失败");
            }
        } catch (Exception e) {
            System.out.println("串口打开失败"+e.getMessage());
            return AjaxResult.success("串口指令发送失败");
        }
        return AjaxResult.success("串口指令发送成功");
    }
}
