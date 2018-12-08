package com.nzf.microservice.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class NewRibbonRuleConfig {

    @Autowired
    private IClientConfig iClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl(false,"/health");
    }

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new AvailabilityFilteringRule();
//        return new RandomRule();
    }
}
