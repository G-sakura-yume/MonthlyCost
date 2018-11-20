package com.example.demo.asset.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.service.AssetService;

@Controller
public class AssetGrafController {

	@Autowired
	AssetService assetService;

	@GetMapping("/assetGlaf")
	public String getAssetGlaf(Model model, Principal principal) {
		model.addAttribute("contents", "asset/assetGlaf :: assetGlaf_contents");
		List<Asset> assetList = assetService.selectMany(principal.getName());
		int[] point = assetService.createGlafPoint(assetList);
		//        int point[] = {1000,2000,3000,3000,4000,5000,2000,4000,3500};
		String label[] = { "2018年7月", "8月", "9月", "10月", "11月", "12月", "1月", "2月", "3月" };
		model.addAttribute("label", label);
		model.addAttribute("point", point);
		return "home/homeLayout";
	}
}
