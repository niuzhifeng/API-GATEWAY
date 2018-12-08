package com.nzf.microservice.dao;

import com.nzf.microservice.config.GenericRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {

    @Autowired
    private GenericRest genericRest;
   
    public String getAll(String appName,String method){
        String url = "http://" + appName + method;
//        url = "direct://http://127.0.0.1:1111/student/getAll";
//        url = "direct://http://127.0.0.1:2222/student/getAll";

        return genericRest.get(url, new ParameterizedTypeReference<String>(){}).getBody();
    }
}
