package com.sosoneo.dd.util.response;

/**
 * @author sosoneo
 */
public class ResponseUtil {
    public static Response success(Object object) {
        Response result = new Response();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Response success() {
        return success(null);
    }

    public static Response error(Integer code, String msg) {
        Response result = new Response();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Response error(ResponseEnum responseEnum) {
        Response result = new Response();
        result.setCode(responseEnum.getCode());
        result.setMsg(responseEnum.getMsg());
        return result;
    }
}
