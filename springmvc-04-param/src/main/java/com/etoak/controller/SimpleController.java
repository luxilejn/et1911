package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于测试简单参数传递 <BR>
 * - 使用HttpServletRequest接收参数 <BR>
 * - 使用基本数据类型、String接收参数
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {

	/**
	 * 第一种接收参数的方式: 使用HttpServletRequest <BR>
	 * 第一种向request域传值的方式: 使用HttpServletRequest
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		// 接收前端传入的参数name
		String name = request.getParameter("name");

		// if(name == null || "".equals(name)){ }
		if (StringUtils.isEmpty(name)) {
			name = "World";
		}

		// 向request域传值
		request.setAttribute("result", "Hello " + name);

		// webapp/pages/param.jsp
		return "param";
	}

	/**
	 * 第二种接收参数的方式：使用基本数据类型 + String <BR>
	 * 第二种向request域传值的方式：使用ModelAndView
	 * 
	 * 注解：@RequestParam可以对参数进行限制 <BR>
	 * 属性value:可以设置参数名称（前端传参的名称） 属性required:默认是true，表示参数必须传入 <BR>
	 * 属性defaultValue: 当参数不传的时候，设置一个默认值 <BR>
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/simple", method = { RequestMethod.GET })
	public ModelAndView simple(//
			@RequestParam(required = false, defaultValue = "1") int id, //
			String name) {
		System.out.println("id param - " + id);
		System.out.println("name param - " + name);

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "ModelAndView传值");
		mv.setViewName("param");
		return mv;
	}

}
