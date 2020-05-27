package com.etoak.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {

	/**
	 * 添加车辆信息
	 * 
	 * @param car
	 * @return
	 */
	int addCar(Car car);

	/**
	 * 查询车辆列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param carVo
	 * @param priceList 
	 * @return
	 */
	PageVo<CarVo> queryList(int pageNum, int pageSize, //
			CarVo carVo, String[] priceList);

	/**
	 * 获取所有的品牌
	 * 
	 * @return
	 */
	List<String> getAllBrand();

	/**
	 * 根据品牌查询车系
	 * 
	 * @param brand：品牌可能为空，当品牌为空时，随机查询10个车系
	 * @return
	 */
	List<String> getSeriesByBrand(@Param("brand") String brand);

}
