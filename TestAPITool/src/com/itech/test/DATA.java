package com.itech.test;

public enum DATA {
    URL("https://medium-backend-api.onrender.com/api");

    private String url;
    DATA(String string) {
        // TODO Auto-generated constructor stub
        this.url = string;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
