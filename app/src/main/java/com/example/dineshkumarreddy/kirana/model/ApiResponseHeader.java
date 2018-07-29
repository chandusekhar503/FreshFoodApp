package com.example.dineshkumarreddy.kirana.model;

public class ApiResponseHeader {

    private String message;
    private int code;


    public ApiResponseHeader(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponseHeader{");
        sb.append("message='").append(message).append('\'');
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
