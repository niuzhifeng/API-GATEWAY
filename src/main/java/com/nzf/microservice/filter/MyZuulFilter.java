package com.nzf.microservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * 自定义zuul过滤器
 */
public class MyZuulFilter extends ZuulFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    private String API_FLAG = "api";
    
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String serviceName;
        if(request.getRequestURI().contains(API_FLAG)){
            String uri = request.getRequestURI();
            if(uri.split("/").length >= 3){
                serviceName = request.getRequestURI().split("/")[2];
                logger.info("serviceName:" + serviceName.toUpperCase());

                HttpServletResponse response = ctx.getResponse();
                RibbonApacheHttpResponse ribbonApacheHttpResponse = (RibbonApacheHttpResponse) ctx.get("ribbonResponse");
                try {
                    URL url = new URL(ribbonApacheHttpResponse.getRequestedURI() +"");
                    ctx.addZuulResponseHeader("localUrl",url.getProtocol() + "//"+ url.getHost() + ":" + url.getPort());
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }

                response.addCookie(new Cookie("appKey",serviceName.toUpperCase()));
                response.setHeader("userInfo", new Date().getTime() + "");
                return serviceName.toUpperCase();
            }
        }
        return null;
    }
}
