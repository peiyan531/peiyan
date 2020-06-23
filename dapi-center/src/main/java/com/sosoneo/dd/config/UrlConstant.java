package com.sosoneo.dd.config;

/**
 * 项目中的URL常量定义类
 *
 * @author sosoneo
 */
public class UrlConstant {
    /**
     * 获取access_token
     */
    public static final String URL_GET_TOKKEN = "https://oapi.dingtalk.com/gettoken";
    /**
     * 获取用户ID
     */
    public static final String URL_GET_USER_INFO = "https://oapi.dingtalk.com/user/getuserinfo";
    /**
     * 获取用户详情
     */
    public static final String URL_USER_GET = "https://oapi.dingtalk.com/user/get";
    /**
     * 通知审批通过
     */
    public static final String URL_ATTENDANCE_APPROVE_FINSH = "https://oapi.dingtalk.com/topapi/attendance/approve/finish";
    /**
     * 发起审批实例的接口url
     */
    public static final String URL_PROCESSINSTANCE_CREATE = "https://oapi.dingtalk.com/topapi/processinstance/create";
    /**
     * 获取审批实例的接口url
     */
    public static final String URL_PROCESSINSTANCE_GET = "https://oapi.dingtalk.com/topapi/processinstance/get";
    /**
     * 发送企业通知消息的接口url
     */
    public static final String MESSAGE_ASYNCSEND = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";
    /**
     * 删除企业回调接口url
     */
    public static final String DELETE_CALLBACK = "https://oapi.dingtalk.com/call_back/delete_call_back";
    /**
     * 注册企业回调接口url
     */
    public static final String REGISTER_CALLBACK = "https://oapi.dingtalk.com/call_back/register_call_back";

}
