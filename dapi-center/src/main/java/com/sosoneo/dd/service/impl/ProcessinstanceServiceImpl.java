package com.sosoneo.dd.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.sosoneo.dd.config.Constant;
import com.sosoneo.dd.config.UrlConstant;
import com.sosoneo.dd.domain.ProcessInstanceInputVO;
import com.sosoneo.dd.service.ProcessinstanceService;
import com.sosoneo.dd.util.AccessTokenUtil;
import com.sosoneo.dd.util.response.Response;
import com.sosoneo.dd.util.response.ResponseUtil;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author sosoneo
 */
@Service
public class ProcessinstanceServiceImpl implements ProcessinstanceService {
    @Override
    public Response<Object> startProcessinstanceService(ProcessInstanceInputVO processInstance) throws ApiException {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_PROCESSINSTANCE_CREATE);
            OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
            request.setAgentId(Constant.AGENTID);
            request.setProcessCode(Constant.PROCESS_CODE);
            request.setFormComponentValues(processInstance.generateForms());

            /**
             * 如果想复用审批固定流程，使用或签会签的话，可以不传审批人，具体请参考文档： https://open-doc.dingtalk.com/microapp/serverapi2/ebkwx8
             * 本次quickstart，演示不传审批人的场景
             */
            request.setOriginatorUserId(processInstance.getOriginatorUserId());
            request.setDeptId(processInstance.getDeptId());
            request.setCcList(processInstance.getOriginatorUserId());
            request.setCcPosition("FINISH");

            OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());
            System.out.println(response.getBody());

            if (response.getErrcode().longValue() != 0) {
                return ResponseUtil.error(Integer.parseInt(response.getErrorCode()), response.getErrmsg());
            }
            return ResponseUtil.success(response.getProcessInstanceId());
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
