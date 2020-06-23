package com.sosoneo.dd.config;

/**
 * 项目中的常量定义类
 *
 * @author sosoneo
 */
public class Constant {
    /**
     * 企业corpid, 需要修改成开发者所在企业
     */
    public static final String CORP_ID = "ding1e12e2ea53cd094c4ac5d6980864d335";
    /**
     * 开发者后台->企业自建应用->选择您创建的E应用->查看->AppKey
     */
    public static final String APP_KEY = "dingklyylsdgxxzpibfv";
    /**
     * 开发者后台->企业自建应用->选择您创建的E应用->查看->AppSecret
     */
    public static final String APP_SECRET = "Mv3FSgwkT0szELCfWFW1naYs3zi_mE__kWAd7j9j-USONn3fOwb3WmK7aFrR9EGM";
    /**
     * 审批模板唯一标识，可以在审批管理后台找到
     */
    public static final String PROCESS_CODE = "PROC-F7E79307-718E-46DB-A597-1222291646C5";
    /**
     * 应用的agentdId，登录开发者后台可查看
     */
    public static final Long AGENTID = 682278241L;
    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "1234567890123456789012345678901234567890123";
    /**
     * 加解密需要用到的token，企业可以随机填写。如 "12345"
     */
    public static final String TOKEN = "aaaaa";
    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "http://yklxa.vaiwan.com";
}
