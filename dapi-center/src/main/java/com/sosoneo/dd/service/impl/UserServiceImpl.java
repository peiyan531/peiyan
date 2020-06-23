package com.sosoneo.dd.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.sosoneo.dd.config.UrlConstant;
import com.sosoneo.dd.service.UserService;
import com.sosoneo.dd.util.AccessTokenUtil;
import com.sosoneo.dd.util.response.Response;
import com.sosoneo.dd.util.response.ResponseEnum;
import com.sosoneo.dd.util.response.ResponseUtil;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sosoneo
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 获取用户信息
     * @param authCode
     * @return
     * @throws ApiException
     */
    @Override
    public Response<Object> getUserInfo(String authCode) throws ApiException {
        if (authCode.length() == 0) {
            return ResponseUtil.error(ResponseEnum.NO_AUTH_CODE);
        }
        String accessToken = AccessTokenUtil.getToken();

        // 获取用户信息
        DingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_GET_USER_INFO);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(authCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
        // 查询得到当前用户的userId
        // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
        String userId = response.getUserid();

        Object detailInfo = getDetailInfo(accessToken, userId);
        System.out.println(detailInfo);
        // 返回结果
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("accessToken", accessToken);
        resultMap.put("detailInfo", detailInfo);
        return ResponseUtil.success(resultMap);
    }

    /**
     * 获取用户详细信息
     * @param accessToken
     * @param userId
     * @return
     * @throws ApiException
     */
    @Override
    public Object getDetailInfo(String accessToken, String userId) throws ApiException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_USER_GET);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            Object object = JSON.parse(response.getBody());
            return object;
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
