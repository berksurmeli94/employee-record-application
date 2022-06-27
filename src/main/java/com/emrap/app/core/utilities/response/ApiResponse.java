package com.emrap.app.core.utilities.response;

public class ApiResponse<T> {

    private T data;
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                " data='" + getData() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }

}
