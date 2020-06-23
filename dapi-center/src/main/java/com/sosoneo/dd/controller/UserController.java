package com.sosoneo.dd.controller;

import com.sosoneo.dd.service.UserService;
import com.sosoneo.dd.util.response.Response;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @author sosoneo
 */
@Api(value = "基础Controller")
@RestController
@RequestMapping("/base")
public class UserController {
    @Autowired
    UserService userService;

    @ApiIgnore
    @RequestMapping("/")
    public String index() {
        return "Base";
    }

    @ApiIgnore
    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        return Collections.singletonMap("success", true);
    }

    @ApiOperation(value = "获取用户信息", notes = "通过免登授权码和access_token获取用户的信息")
    @ApiImplicitParam(name = "authCode", value = "免登授权码", required = false, dataType = "string", paramType = "body")
    @RequestMapping(value = "/get_user_info")
    public Response<Object> getUserInfo(@RequestParam(value = "authCode", required = false, defaultValue = "") String authCode, HttpServletResponse response) throws ApiException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        return userService.getUserInfo(authCode);
    }
}
