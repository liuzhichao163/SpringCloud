package com.liuzhichao.springcloud.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuzhichao.microseviceloud.entity.Dept;
import com.liuzhichao.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public Long add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if(dept == null) {
			throw new RuntimeException("没有该数据！");
		}
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		 
		return new Dept().setDeptno(id).setDname("没有此数据！").setDb_source("查询不到！");
	}

}
