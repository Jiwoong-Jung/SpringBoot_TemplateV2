package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyTestDao;
import com.study.springboot.jdbc.MyUserDTO;
import com.study.springboot.spring.TestDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	TestDao testDao;
	
	@Autowired
	MyTestDao myTestDao;
	
	@GetMapping("/main")
	public String main() {
		
		log.info("-----테스트: {}", testDao.count());
		log.info("-----마이바티스 테스트: {}", myTestDao.myCount());
		return "main";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<MyUserDTO> list() {
		return myTestDao.list();
	}

}
