package com.beck.api.dingTalk;
import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.StringUtils;
import com.beck.dingTalk.core.auth.DingTalkOauth;
import com.dingtalk.api.response.OapiV2UserGetuserinfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("钉钉接入信息")
@RestController
@RequestMapping(value = "${apiPath}/dingTalk")
public class DingTalkApi {

    @ApiOperation("获取钉钉用户信息")
    @GetMapping(value = "/getUserInfo")
    public AjaxResult getUserInfo(@ApiParam(name = "code", value = "免登录码", required = true) String code,
                                  @ApiParam(name = "appId", value = "微应用Id", required = true) String appId) {
        if (StringUtils.isBlank(code)) {
            return AjaxResult.error("免登码不能为空");
        }
        if (StringUtils.isBlank(appId)) {
            return AjaxResult.error("微应用Id不能为空");
        }
        String appKey = "";
        String appSecret = "";
        if("1".equals(appId)){
            appKey = "ding3xro15jth1be8fcs";
            appSecret = "U8XxUZGaBEkc-Uzl9eGD8mEEVoy6iKBJVM2YMS9aL58EEvHTksA3ooCMZt9ZJXgz";
        }
        String token = DingTalkOauth.getToken(appKey, appSecret);
        if(StringUtils.isNotBlank(token)){
            OapiV2UserGetuserinfoResponse.UserGetByCodeResponse userInfo = DingTalkOauth.getUserInfo(code, token);
            if(userInfo == null){
                return AjaxResult.error("获取用户信息失败");
            }
            return AjaxResult.success("获取信息成功", userInfo);
        }
        return AjaxResult.error("获取用户信息失败");
    }


}
