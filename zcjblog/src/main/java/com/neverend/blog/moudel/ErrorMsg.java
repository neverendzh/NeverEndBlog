package com.neverend.blog.moudel;

/**
 * 上传文件错误信息
 */
public class ErrorMsg {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                "message='" + message + '\'' +
                '}';
    }
}
