package com.liuzhichao.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liuzhichao.microseviceloud.entity.Dept;

@Mapper
public interface DeptDao {
	
	public Long addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
