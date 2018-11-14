package com.example.demo.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.model.AssetRegistrationForm;
import com.example.demo.asset.domain.service.AssetService;

@Controller
public class AssetRegistrationController {

	@Autowired
	AssetService assetService;

	@GetMapping("/assetRegist")
	public String getAssetRegistration(@ModelAttribute  AssetRegistrationForm form,Model model) {
		model.addAttribute("contents", "asset/regist :: regist_contents");
		return "asset/regist";
	}

	@PostMapping("/assetRegist")
	public String postAssetRegistration(@ModelAttribute @Validated AssetRegistrationForm form,BindingResult bindResult,Model model) {
		model.addAttribute("contents", "asset/regist :: regist_contents");
		if (bindResult.hasErrors()) return getAssetRegistration(form,model);
		System.out.println(form);
		Asset asset = new Asset();
		asset.setAssetName(form.getAssetName());
		asset.setPurchaseDate(form.getPurchaseDate());
		asset.setUsedTerm(form.getUsedTerm());
		asset.setUserId("yamada@xxx.co.jp");
		try {
			boolean result=assetService.insert(asset);
			if (result) {
				System.out.println("inset成功");
			}else {
				System.out.println("inset失敗");
			}
		} catch (DataAccessException e) {
			System.out.println("inset失敗(エラー)");
		}
		return "asset/regist";
	}

}
