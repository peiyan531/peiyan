package com.sosoneo.dd.service;

import com.sosoneo.dd.util.response.Response;
import com.taobao.api.ApiException;

/**
 * @author sosoneo
 */
public interface AttendanceService {
    /**
     * 通知审批通过
     * 审批通过通知考勤修改打卡结果，支持加班/请假/外出/出差类型
     * @param userId
     * @return
     * @throws ApiException
     */
    public Response<Object> approveAttendanceByUserId(String userId) throws ApiException;

    /**
     * 通知审批通过
     * 审批通过通知考勤修改打卡结果，支持加班/请假/外出/出差类型
     * @param processInstanceId
     * @return
     * @throws ApiException
     */
    public Response<Object> approveAttendanceByProcessInstanceId(String processInstanceId) throws ApiException;
}
