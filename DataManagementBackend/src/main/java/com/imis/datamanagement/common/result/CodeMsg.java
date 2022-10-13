package com.imis.datamanagement.common.result;

public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg EMAIL_EMPTY = new CodeMsg(500212, "邮箱不能为空");
    public static CodeMsg EMAIL_ERROR = new CodeMsg(500213, "邮箱格式错误");
    public static CodeMsg EMAIL_NOT_EXIST = new CodeMsg(500214, "邮箱不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    public static CodeMsg CODE_ERROR = new CodeMsg(500216, "验证码错误");
    public static CodeMsg PRIMARY_ERROR = new CodeMsg(500217, "主键冲突");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500218, "用户不存在");
    public static CodeMsg EMAIL_EXIST = new CodeMsg(500219, "用户已存在");

//

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
