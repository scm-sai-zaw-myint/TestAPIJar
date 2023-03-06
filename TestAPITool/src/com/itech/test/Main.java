package com.itech.test;

import com.itech.api.tools.Response;
import com.itech.api.v1.tools.API;

public class Main {
    static final String access = "EAAKZCZAYhca2EBAJmjLIgkXomaIQNhYpRg0Vk3u6TEfMHzv50arRAHobaZC2TpsuNbJbEHj90z2WGWzT3UauURAjcIIeOwaykaZCZCaG3yHFiSGgWQBZB1qZCHLJU7gvYOOYZCoBCch08RlKjiBBkHZAExPSE0NLZAgjt9pj9Vh36lmljjCc5mJVCWQj0PB92GD8KZBoQwymvnVW28omZAyQinUToy14EnSjlgmCnJ9fZBigWhZBjoDpYRZBSZAqTQRZABhfy1xoZD";
    /**
     * POST, PUT need a body params.<br>
     * example -> <br>
     * <code>
     *    //body can also be a POJO class or a String<br>
     *    String body = "{\"username\": \"John\"}"
     *    <br>
     *    API.post("https://wwww.example.com", body).then((r)->r).exception((e)->e);
     * </code>
     * <br>
     * <p style="color: darkgray;">
     * 		NOTE: You can see log file in ~/user-home/itechapi/log/applog.log
     * </p>
     */
    static API API = new API();
    
    /**
     * Main methods
     * @param args String Array
     */
    public static void main(String[] args) {
    	//use in internal
        use_API_With_Internal_Callback();
        
        //use with external
        use_API_With_External_Callback();
        
    }
    
    static void use_API_With_Internal_Callback() {
        //to call GET method 
        
        API.get("https://graph.facebook.com/me?access_token=".concat(access).concat("&fields=id,name,friends,feed"))
        //asynchronous callback
        .then((response)->{
            System.out.println(response);
            //callback need a return statement
            return response;
        })
        //asynchronous exception callback
        .exception(e -> {
            System.out.println(e);
            e.getException().printStackTrace();
            //callback need a return statement
            return e;
        });
    }
    
    static void use_API_With_External_Callback() {
        //to call GET method 
        API.get("https://graph.facebook.com/me?access_token=".concat(access).concat("&fields=id,name,friends,feed"))
        //asynchronous callback
        .then((response)-> testExternalCallback(response))
        //asynchronous exception callback
        .exception(e -> testExceptionCallback(e));
    }
    
    static Response testExternalCallback(Response r) {
        System.out.println(r);
        return r;
    }
    static Response testExceptionCallback(Response e) {
        e.getException().printStackTrace();
        return e;
    }
}