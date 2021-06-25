package com.nadim.springbootconcepts;

public class CustomBean {

    String message;
    String data;

    public CustomBean() {
    }

    public CustomBean(String message, String data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
