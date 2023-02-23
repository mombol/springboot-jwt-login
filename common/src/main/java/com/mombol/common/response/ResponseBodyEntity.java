package com.mombol.common.response;

public class ResponseBodyEntity<T> {

    private String code;
    private String message;
    private T data;

    public ResponseBodyEntity() {
    }

    public ResponseBodyEntity(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseBodyEntity success(Object data) {
        return new ResponseBodyEntity(ResponseCode.SUCCESS.getCode(), "OK", data);
    }

    public static ResponseBodyEntity<Object> fail(ResponseCode responseCode) {
        return new ResponseBodyEntity<Object>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static ResponseBodyEntity<Object> fail(String code, String message) {
        return new ResponseBodyEntity<Object>(code, message, null);
    }

}
