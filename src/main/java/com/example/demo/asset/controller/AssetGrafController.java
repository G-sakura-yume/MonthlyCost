package com.example.demo.asset.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.asset.domain.service.AssetService;

@Controller
public class AssetGrafController {

	@Autowired
	AssetService assetService;

	@GetMapping("/assetGlaf")
	public String getAssetGlaf(Model model,Principal principal) {
		model.addAttribute("contents", "asset/assetGlaf :: assetGlaf_contents");
		return "home/homeLayout";
	}
}
