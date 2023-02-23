package com.mombol.common.response;

public enum  ResponseCode {

    SUCCESS("200", "成功"),
    BAD_REQUEST("400", "错误请求"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误");


    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
