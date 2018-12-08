package com.nzf.microservice.service;

import com.nzf.microservice.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    private CommonDao commonDao;

    public String getAll(String appName,String method){
        return commonDao.getAll(appName,method);
    }
}
