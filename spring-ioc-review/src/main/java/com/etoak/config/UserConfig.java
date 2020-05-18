package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

/**
 * 注解@Configuration：相当于xml的根元素<beans>标签 <BR>
 * 表示这是一个spring ioc容器 <BR>
 * 
 * @author lenovo
 *
 */
@Configuration
public class UserConfig {

	/**
	 * 使用@Bean注册spring bean <BR>
	 * 返回类型相当于<bean>标签的class属性 <BR>
	 * 方法名可以认为是<bean>标签的id属性 <BR>
	 * 
	 * @return
	 */
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public UserAction userAction(@Qualifier("userService")
	UserService userService) {
		UserAction userAction = new UserAction();
		// userAction.setUserService(this.userService());
		
		// 配合@Qualifier使用
		userAction.setUserService(userService);
		return userAction;
	}

}
