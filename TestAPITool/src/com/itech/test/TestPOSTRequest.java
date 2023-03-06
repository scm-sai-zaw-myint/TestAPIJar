package com.itech.test;

import com.itech.api.v1.tools.API;

public class TestPOSTRequest {

    static API api = new API();
    //Test with JSON String
    static String testWithJson() {
        //login email and password
        String loginCredential = "{\"email\":\"admin@gmail.com\",\"password\":\"admin@123\"}";
        return Constant.loginUserToMedium(loginCredential);
    }
    
    //POJO class
    static class CommentRequest{
        String body;
        Integer parentCommentId;
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
        public Integer getParentCommentId() {
            return parentCommentId;
        }
        public void setParentCommentId(Integer parentCommentId) {
            this.parentCommentId = parentCommentId;
        }
        
    }
    
    static void testWithPOJO(String accessToken) {
        CommentRequest category = new CommentRequest();
        category.setBody("Comment to post using api!");
        //we are passing authorization header to request!
        api.post(DATA.URL.getUrl().concat("/1/comments"), category, "Content-Type","application/json","Authorization", "Bearer ".concat(accessToken))
        .then((response)->{
            System.out.println(response);
            return response;
        })
        .exception((e)->{
            e.getException().printStackTrace();
            return e;
        });
    }

    public static void main(String[] args) {
        String accessToken = testWithJson();
        testWithPOJO(accessToken);
    }
}
