package com.nzf.microservice;import com.netflix.zuul.ZuulFilter;import com.nzf.microservice.config.NewRibbonRuleConfig;import com.nzf.microservice.filter.MyZuulFilter;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.EnableAutoConfiguration;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.ServiceInstance;import org.springframework.cloud.client.SpringCloudApplication;import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;import org.springframework.cloud.client.discovery.DiscoveryClient;import org.springframework.cloud.client.discovery.EnableDiscoveryClient;import org.springframework.cloud.netflix.hystrix.EnableHystrix;import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;import org.springframework.cloud.netflix.ribbon.RibbonClient;import org.springframework.cloud.netflix.zuul.EnableZuulProxy;import org.springframework.context.annotation.Bean;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.ResponseBody;import java.util.List;/** * ribbon和zuul都可以实现负载均衡 * 区别： ribbon属于客户端负载均衡 * 		 zuul属于服务端负载均衡 */@EnableAutoConfiguration//@RibbonClient(name = "student",configuration = NewRibbonRuleConfig.class)@SpringBootApplication@EnableZuulProxy@EnableHystrixDashboard@Controllerpublic class ApiGatewayApplication {	@Autowired	private DiscoveryClient discoveryClient;	@GetMapping("/student")	@ResponseBody	public List<ServiceInstance> getStudentRegisty(){		 return discoveryClient.getInstances("student");	}	@GetMapping("/apigateway")	@ResponseBody	public List<ServiceInstance> getApiGateWayRegisty(){		return discoveryClient.getInstances("api-gateway");	}	@Bean	public ZuulFilter MyZuulFilter(){		MyZuulFilter myZuulFilter = new MyZuulFilter();		return myZuulFilter;	}	public static void main(String[] args) {		SpringApplication.run(ApiGatewayApplication.class, args);	}}