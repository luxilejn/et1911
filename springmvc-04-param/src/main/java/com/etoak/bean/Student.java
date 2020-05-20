package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter // get方法
//@Setter // set方法
//@ToString // toString()方法
@Data // get\set\toString...
@NoArgsConstructor // 无参构造方法
@AllArgsConstructor // 按照参数顺序生成构造方法
public class Student {

	private Integer id;

	private String name;

	private Integer age;

	private List<String> hobbyList;
	
	// 存储id和name两个key
	private Map<String, Object> stuMap;

}
