package com.liuzhichao.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuzhichao.microseviceloud.entity.Dept;
import com.liuzhichao.springcloud.dao.DeptDao;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptDao deptDao; 
	
	@Override
	public Long add(Dept dept) {
		Long detpno = -1L;
		//获取插入数据库受影响的额行数
		Long num = deptDao.addDept(dept);
		if(num == 1) {
			//插入数据库后将主键id返回到了实体类中，在此处获取即可。
			detpno = dept.getDeptno();
		}
		return detpno;
				
	}

	@Override
	public Dept get(Long id) {
		
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		
		return deptDao.findAll();
	}

}
