package com.example.demo.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents","home/home :: home_contents");
		return "home/homeLayout";
	}
	@PostMapping("/logout")
	public String posthome() {
		return"redirect:/login";
	}
}
