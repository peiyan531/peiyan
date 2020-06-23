package com.sosoneo.dd.service;

import com.sosoneo.dd.util.response.Response;
import com.taobao.api.ApiException;

/**
 * @author sosoneo
 */
public interface UserService {

    /**
     * 通过免登授权码和access_token获取用户的信息
     * @param authCode
     * @return
     * @throws ApiException
     */
    public Response<Object> getUserInfo(String authCode) throws ApiException;

    /**
     * 获取用户详细信息
     * @param accessToken
     * @param userId
     * @return
     * @throws ApiException
     */
    public Object getDetailInfo(String accessToken, String userId) throws ApiException;
}
