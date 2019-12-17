package com.liuzhichao.microseviceloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liuzhichao.microseviceloud.entity.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("没有此数据！").setDb_source("没有此数据库！");
			}
			
			@Override
			public Long add(Dept dept) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
