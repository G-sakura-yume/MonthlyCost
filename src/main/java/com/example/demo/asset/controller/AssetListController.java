package com.example.demo.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.model.AssetListForm;
import com.example.demo.asset.domain.service.AssetService;

@Controller
public class AssetListController {

	@Autowired
	AssetService assetService;

	@GetMapping("/assetList")
	public String getAssetList(@ModelAttribute @Validated AssetListForm form,BindingResult bindResult,Model model ) {
		model.addAttribute("contents", "asset/assetList :: assetList_contents");
		List<Asset> assetList = assetService.selectMany();
		model.addAttribute("assetList",assetList);
		return "home/homeLayout";
	}
}
