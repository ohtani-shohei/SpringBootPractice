package com.example.taskmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/task-complete")
	private String completeTask() {
		return "task-complete";
	}
}
