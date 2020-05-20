package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Student;
import com.etoak.bean.User;
import com.etoak.vo.ResultVo;

@RestController // @Controller + @ResponseBody(会应用到所有方法上)
@RequestMapping("/json")
public class JsonController {

	/**
	 * 将json转成Map
	 * 
	 * @param jsonMap
	 * @return
	 */
	@PostMapping(value = "/jsonToMap", produces = "application/json;charset=UTF-8")
	public String jsonToMap(@RequestBody Map<String, Object> jsonMap) {
		System.out.println(jsonMap);

		// string => json
		return "{\"msg\":\"success\"}";
	}

	/**
	 * 将json参数转成List
	 */
	@PostMapping("/jsonToList")
	public Map<String, Object> jsonToList(@RequestBody List<User> userList) {
		// 打印参数
		userList.forEach(x -> System.out.println(x));

		// 封装结果，spring mvc可以自动将map转成json返回
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", 200);
		resultMap.put("msg", "SUCCESS");
		return resultMap;
	}

	/**
	 * json转成java bean
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping("/jsonToBean")
	public ResultVo jsonToBean(@RequestBody Student student) {
		// 打印参数
		System.out.println(student);

		return new ResultVo(200, "Success");
	}
	
	

}
