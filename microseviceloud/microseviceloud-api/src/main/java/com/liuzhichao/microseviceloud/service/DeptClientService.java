package com.liuzhichao.microseviceloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuzhichao.microseviceloud.entity.Dept;
/**
 * 1、fegin接口不能使用GetMapping之类的组合注解
 * 2、使用pathVariable必须指定value
 * @author ASUS
 *
 */
//value对应的微服务
//@FeignClient(value="MICROSERVICECLOUD-PROVIDER")
@FeignClient(value="MICROSERVICECLOUD-PROVIDER",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public Long add(Dept dept);
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);   //要和Controller一样加上@PathVariable注解，并且要加value值
	
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();
}
