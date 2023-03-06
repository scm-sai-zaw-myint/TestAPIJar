package com.itech.test;

import com.itech.api.v1.tools.API;

public class TestGETRequest {
    static API api = new API();
    static void getPostsFromMedium() {
        api.get(DATA.URL.getUrl().concat("/posts"))
        //success callback
        .then((response)->{
            System.out.println(response);
            return response;
        })
        //fails callback
        .exception((e)->{
            e.getException().printStackTrace();
            return e;
        });
    }
    public static void main(String[] args) {
        getPostsFromMedium();
    }
}
