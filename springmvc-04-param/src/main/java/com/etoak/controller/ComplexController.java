package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * 第四种接收参数的方式：使用数组接收参数 <BR>
	 * 第四种向request传值的方式：使用ModelMap
	 * 
	 * @param hobby
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/array")
	public String array(String[] hobby, ModelMap modelMap) {
		for (String hobbyStr : hobby) {
			System.out.println("hobby - " + hobbyStr);
		}

		modelMap.addAttribute("result", "使用ModelMap传值");
		return "param";
	}

	/**
	 * 第五种接收参数的方式：使用List(封装到java bean中) <BR>
	 * 第五种向request域传值的方式：使用Map
	 * 
	 * @param student
	 * @param map
	 * @return
	 */
	@PostMapping("/list")
	public String list(Student student, Map<String, Object> map) {
		List<String> hobbyList = student.getHobbyList();

		// 当它不为空的时遍历
		if (!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}

		map.put("result", "使用Map传值");
		return "param";
	}

	/**
	 * 第六种接收参数的方式：使用map(把map封装在java bean中)
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/map", produces = { "text/plain" })
	@ResponseBody // 可以返回json、xml、纯文本
	public String map(Student student) {
		System.out.println(student.getStuMap());
		return "success";
	}

}
