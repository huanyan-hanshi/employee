package com.lin.pojo;
public enum Error {
    ERROR("非法操作|");
    private String message;
    Error(String message){this.message=message;}

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                '}';
    }
}
