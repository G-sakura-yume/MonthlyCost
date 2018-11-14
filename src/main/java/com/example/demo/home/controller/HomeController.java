package com.example.demo.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents","home/home :: home_contents");
		return "home/homeLayout";
	}
	@PostMapping("/logout")
	public String posthome() {
		return"redirect:/login";
	}

	@GetMapping("/userList")
	public String getUserList(Model model) {
		model.addAttribute("contents","home/userList :: userList_contents");
		List<User> userList = userService.selectMany();
		model.addAttribute("userList",userList);
		return "home/userList";
	}
}
