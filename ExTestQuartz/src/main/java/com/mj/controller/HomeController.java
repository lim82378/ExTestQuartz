package com.mj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mj.service.SchedulerService;

@Controller
public class HomeController {
	
	@Autowired
	SchedulerService ScheSvc;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/start")
	public String start() {
		try {
			logger.error("스케줄러 시작됨");
			ScheSvc.startScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	@RequestMapping("/end")
	public String end() {
		try {
			logger.error("스케줄러 종료됨");
			ScheSvc.endScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}
