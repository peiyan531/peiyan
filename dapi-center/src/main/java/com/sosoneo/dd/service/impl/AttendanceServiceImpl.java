package com.sosoneo.dd.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceApproveFinishRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.response.OapiAttendanceApproveFinishResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.sosoneo.dd.config.UrlConstant;
import com.sosoneo.dd.service.AttendanceService;
import com.sosoneo.dd.util.AccessTokenUtil;
import com.sosoneo.dd.util.response.Response;
import com.sosoneo.dd.util.response.ResponseUtil;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author sosoneo
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Override
    public Response<Object> approveAttendanceByUserId(String userId) throws ApiException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_ATTENDANCE_APPROVE_FINSH);
            OapiAttendanceApproveFinishRequest req = new OapiAttendanceApproveFinishRequest();
            req.setUserid(userId);
            req.setBizType(2L);
            req.setFromTime("2020-01-02");
            req.setToTime("2020-01-02");
            req.setDurationUnit("day");
            req.setCalculateModel(1L);
            req.setTagName("出差");
            req.setApproveId("1234");
            req.setJumpUrl("https://baidu.com");
            OapiAttendanceApproveFinishResponse rsp = client.execute(req, AccessTokenUtil.getToken());
            System.out.println(rsp.getBody());
            return ResponseUtil.success(JSON.parse(rsp.getBody()));
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response<Object> approveAttendanceByProcessInstanceId(String processInstanceId) throws ApiException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_PROCESSINSTANCE_GET);
            OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
            request.setProcessInstanceId(processInstanceId);
            OapiProcessinstanceGetResponse response = client.execute(request, AccessTokenUtil.getToken());
            String recieverUserId = response.getProcessInstance().getOriginatorUserid();

            return approveAttendanceByUserId(recieverUserId);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
