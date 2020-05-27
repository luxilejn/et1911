package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

public interface CarMapper {

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
	 * @param carVo
	 * @return
	 */
	List<CarVo> queryList(CarVo carVo);

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
