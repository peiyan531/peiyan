package com.sosoneo.dd.util.response;

/**
 * @author sosoneo
 */
public enum  ResponseEnum {
    /**
     * 未知错误
     */
    UNKONW_ERROR(-1, "未知错误"),
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 无accessToken
     */
    NO_ACCESS_TOKEN(100, " 无accessToken，请先获取accessToken"),
    /**
     * 无authCode
     */
    NO_AUTH_CODE(101, " 无authCode，请于前端进行上传");

    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
