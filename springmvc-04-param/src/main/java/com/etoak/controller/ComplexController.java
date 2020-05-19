package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;

/**
 * 测试java bean接收参数 <BR>
 * 测试数组接收参数 <BR>
 * 测试List接收参数 <BR>
 * 测试Map接收参数 <BR>
 * 
 */
@Controller
@RequestMapping("/complex")
public class ComplexController {

	/**
	 * 第三种接收参数的方式：使用java bean <BR>
	 * 第三种向request域传值的方式：使用Model对象
	 * 
	 * @param student
	 * @param model
	 * @return
	 */
	// Get请求： @RequestMapping的method属性指定
	// Get请求：@GetMapping
	@GetMapping("/bean")
	public String bean(Student student, Model model) {
		System.out.println(student);
		model.addAttribute("result2", "使用Model传值");

		// 请求转发到/simple/simple(这个请求在SimpleController中)
		return "forward:/simple/simple?id=321";
	}

}
