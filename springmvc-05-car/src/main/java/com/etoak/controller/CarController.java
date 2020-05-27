package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {

	@Autowired
	CarService carService;

	/**
	 * 跳转到车辆添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "car/list";
	}

	/**
	 * 添加车辆信息
	 * 
	 * @param file
	 * @param car
	 * @param bindingResult
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/add")
	public String add(MultipartFile file, //
			@Valid Car car, BindingResult bindingResult, //
			HttpServletRequest request) throws IllegalStateException, IOException {

		// 先校验Car
		// 获取所有的校验失败结果集
		List<ObjectError> allErrors = bindingResult.getAllErrors();

		// 如果校验失败结果集不为空，则取出错误校验信息
		if (!CollectionUtils.isEmpty(allErrors)) {
			StringBuffer errorBuf = new StringBuffer();
			for (ObjectError error : allErrors) {
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}

			// 把校验错误信息写到request域，使用请求转发跳转到车辆添加页面
			// request.setAttribute("paramError", errorBuf.toString());
			// return "forward:/car/toAdd";

			// 抛出ParamException异常，让全局异常处理器去处理
			throw new ParamException(errorBuf.toString());
		}

		String originalFilename = file.getOriginalFilename();
		log.info("文件名称 - {}", originalFilename);
		log.info("param car - {}", car);

		// 新文件名称: uuid_originalFilename
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFilename = uuid + "_" + originalFilename;

		// 目标文件d:/upload/uuid_老文件名.jpg
		File destFile = new File("d:/upload", newFilename);

		// 执行上传
		file.transferTo(destFile);

		// 设置图片地址
		car.setPic("/pic/" + newFilename);

		// 调用服务层添加车辆信息
		carService.addCar(car);

		// 重定向方式返回页面
		return "redirect:/car/toAdd";
	}

	/**
	 * 车辆列表查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param carVo
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(@RequestParam(required = false, defaultValue = "1") int pageNum, //
			@RequestParam(required = false, defaultValue = "8") int pageSize, //
			CarVo carVo,//
			String[] priceList) {
		return carService.queryList(pageNum, pageSize, carVo, priceList);
	}

	/**
	 * 查询所有品牌
	 * 
	 * @return
	 */
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand() {
		return carService.getAllBrand();
	}

	/**
	 * 根据品牌查询车系，如果品牌为空，则随机获取10个车系
	 * 
	 * @param brand
	 * @return
	 */
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand) {
		return carService.getSeriesByBrand(brand);
	}

}
