package com.liuzhichao.microseviceloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor    //构造方法  全参
@NoArgsConstructor		//构造方法  无参
@Data					//get set 方法
@Accessors(chain=true)  //链式访问
public class Dept implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2327437224628301372L;
	private Long deptno;
	private String dname;
	private String db_source;

}
