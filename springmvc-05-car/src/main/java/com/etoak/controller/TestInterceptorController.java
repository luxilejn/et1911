package com.etoak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorController {

	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test invoke!");
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

	@RequestMapping("/test2")
	public void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test2 invoke!");
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

}
