package com.itech.test;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itech.api.v1.tools.API;

public class Constant {
    
    static String accessToken = "";

    @SuppressWarnings("unchecked")
    static Map<?, ?> convertJSON(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = null;
        try {
            data = mapper.readValue(json, Map.class);
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return data;
    }
    
    @SuppressWarnings("unchecked")
    static String loginUserToMedium(Object credential) {
        API api = new API();
        api.post(DATA.URL.getUrl().concat("/auth/request/login"), credential)
        .then((r)->{
            System.out.println(r);
            Map<String, Object> outerData = (Map<String, Object>) Constant.convertJSON(r.getData().toString());
            Map<String, Object> result = (Map<String, Object>) outerData.get("data");
            accessToken = (String) result.get("accessToken");
            return r;
        })
        .exception((e)->{
            e.getException().printStackTrace();
            return e;
        });
        return accessToken;
    }
    
}
