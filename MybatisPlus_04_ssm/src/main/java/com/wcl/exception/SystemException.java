package com.wcl.exception;

public class SystemException extends RuntimeException{
    private Integer code;

    public SystemException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public SystemException(Integer code, String message,Throwable cause) {
        super(message,cause);
        this.code=code;
    }

    public SystemException(Integer code) {
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
