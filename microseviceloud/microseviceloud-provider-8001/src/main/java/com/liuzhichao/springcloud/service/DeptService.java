package com.liuzhichao.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liuzhichao.microseviceloud.entity.Dept;

public interface DeptService {
	
	public Long add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
