package com.sosoneo.dd.service;

import com.sosoneo.dd.domain.ProcessInstanceInputVO;
import com.sosoneo.dd.util.response.Response;
import com.taobao.api.ApiException;

/**
 * @author sosoneo
 */
public interface ProcessinstanceService {
    /**
     * 开始审批
     * @param processInstance
     * @return
     * @throws ApiException
     */
    public Response<Object> startProcessinstanceService(ProcessInstanceInputVO processInstance) throws ApiException;
}
