package com.sosoneo.dd.controller;

import com.sosoneo.dd.service.AttendanceService;
import com.sosoneo.dd.util.response.Response;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * 假勤控制器
 *
 * @author sosoneo
 */
@Api(value = "假勤Controller")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @ApiIgnore
    @RequestMapping("/")
    public String index() {
        return "Attendance";
    }

    @ApiIgnore
    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        return Collections.singletonMap("success", true);
    }

    @ApiOperation(value = "通知审批通过", notes = "审批通过通知考勤修改打卡结果，支持加班/请假/外出/出差类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "string", paramType = "body")
    })
    @RequestMapping(value = "/approve_attendance")
    public Response<Object> approveAttendance(
            @RequestParam(value = "userId", required = true, defaultValue = "") String userId,
            HttpServletResponse response) throws ApiException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return attendanceService.approveAttendanceByUserId(userId);
    }
}
