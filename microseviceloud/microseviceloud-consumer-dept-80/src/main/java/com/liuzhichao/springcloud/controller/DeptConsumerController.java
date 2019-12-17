package com.liuzhichao.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuzhichao.microseviceloud.entity.Dept;

@RestController
public class DeptConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
//    private final String REST_UTL_PREAFIX = "http://localhost:8001";
	 private final String REST_UTL_PREAFIX = "http://MICROSERVICECLOUD-PROVIDER";
    
    @GetMapping("/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
    	System.out.println("-------------id:"+id);
		return restTemplate.getForObject(REST_UTL_PREAFIX+"/dept/get/"+id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping("/consumer/dept/list")
    public List<Dept> getDepts(){
    	
		return restTemplate.getForObject(REST_UTL_PREAFIX+"/dept/list/", List.class);
    }
    
    
    @PostMapping("/consumer/dept/add")
    public Long addDept(@RequestBody Dept dept) {
		return restTemplate.postForObject(REST_UTL_PREAFIX+"/dept/add/",dept,Long.class);
    }
}
