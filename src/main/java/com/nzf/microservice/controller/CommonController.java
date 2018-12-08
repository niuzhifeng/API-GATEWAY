package com.nzf.microservice.controller;

import com.nzf.microservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/common")
@RestController
public class CommonController {

    @Value("${service.student.app.name}")
    private String studentServiceName;

    @Autowired
    private CommonService commonService;
    
    @GetMapping("/{appName}")
    public String getAll(@PathVariable("appName") String appName, @RequestParam("method") String method){
        return commonService.getAll(appName,method);
    }
}
