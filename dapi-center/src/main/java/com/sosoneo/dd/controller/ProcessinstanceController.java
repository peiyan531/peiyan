package com.sosoneo.dd.controller;

import com.sosoneo.dd.domain.ProcessInstanceInputVO;
import com.sosoneo.dd.service.ProcessinstanceService;
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

@Api(value = "官方工作流Controller")
@RestController
@RequestMapping("/processinstance")
public class ProcessinstanceController {
    @Autowired
    ProcessinstanceService processinstanceService;

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

    @ApiOperation(value = "发起审批", notes = "前端填写表单传入")
    @RequestMapping(value = "/start")
    @ResponseBody
    public Response<Object> getUserInfo(@RequestBody ProcessInstanceInputVO processInstance, HttpServletResponse response) throws ApiException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        return processinstanceService.startProcessinstanceService(processInstance);
    }
}
