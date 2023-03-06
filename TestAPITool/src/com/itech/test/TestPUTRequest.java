package com.itech.test;

import com.itech.api.v1.tools.API;

public class TestPUTRequest {

    static API api = new API();
    
    static void test() {
        String loginCredential = "{\"email\":\"admin@gmail.com\",\"password\":\"admin@123\"}";
        String updateUsername = "{\"body\":\"Update Comment by api!\"}";
        String[] headers = new String[] {"Authorization","Bearer ".concat(Constant.loginUserToMedium(loginCredential)),"Content-Type","application/json"};
        api.put(DATA.URL.getUrl().concat("/1/comments/1"), updateUsername, headers)
        .then((r)->{
            System.out.println(r);
            return r;
        })
        .exception(e->{
            e.getException().printStackTrace();
            return e;
        });
    }
    public static void main(String[] args) {
        test();
    }
}
