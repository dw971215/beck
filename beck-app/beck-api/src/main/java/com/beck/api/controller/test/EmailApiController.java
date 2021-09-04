package com.beck.api.controller.test;

import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.article.LoveUtils;
import com.beck.common.utils.email.EmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dawei
 * @Date 2021/6/10 19:39
 */
@RestController
@Api
@RequestMapping(value = "/api/mail")
public class EmailApiController {

    /**
     * 发送邮件
     * @return
     */
    @ApiOperation("发送邮件")
    @GetMapping("/sendEmai")
    public AjaxResult sendEmai(@ApiParam(name = "subject", value = "主题") String subject,
                               @ApiParam(name = "toUser", value = "接收人") String[] toUser

    ) {

        String msg = LoveUtils.getOneS();
        EmailUtils.sendMsg(subject,msg,toUser);
        return AjaxResult.success("发送邮件成功");
    }
}
