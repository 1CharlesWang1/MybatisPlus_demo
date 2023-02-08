package com.wcl.exception;

public class BusinessException extends RuntimeException{
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public BusinessException(Integer code, String message,Throwable cause) {
        super(message,cause);
        this.code=code;
    }

    public BusinessException(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

}
