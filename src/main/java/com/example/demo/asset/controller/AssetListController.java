package com.example.demo.asset.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.model.AssetRegistrationForm;
import com.example.demo.asset.domain.service.AssetService;

@Controller
public class AssetListController {

	@Autowired
	AssetService assetService;

	@GetMapping("/assetList")
	public String getAssetList(Model model, Principal principal) {
		model.addAttribute("contents", "asset/assetList :: assetList_contents");
		List<Asset> assetList = assetService.selectMany(principal.getName());
		model.addAttribute("assetList", assetList);
		return "home/homeLayout";
	}

	@GetMapping("/assetDetail/{id:.+}")
	public String getAssetDetail(@ModelAttribute AssetRegistrationForm form, Model model,
			@PathVariable("id") Long assetId, Principal principal) {
		System.out.println("assetId = " + assetId);
		model.addAttribute("contents", "asset/assetDetail :: assetDetail_contents");
		if (assetId != null && assetId > 0) {
			Asset asset = assetService.selectOne(assetId, principal.getName());
			form.setAssetId(asset.getAssetId());
			form.setAssetName(asset.getAssetName());
			form.setAssetPrice(asset.getAssetPrice());
			form.setPurchaseDate(asset.getPurchaseDate());
			form.setUsedTerm(asset.getUsedTerm());
			model.addAttribute("assetRegistrationForm", form);
		}
		return "home/homeLayout";
	}

	@PostMapping(value = "/assetDetail", params = "update")
	public String postAssetDetailUpdate(@ModelAttribute AssetRegistrationForm form, Model model, Principal principal) {
		System.out.println("更新ボタンの処理");
		Asset asset = new Asset();
		asset.setAssetId(form.getAssetId());
		asset.setAssetName(form.getAssetName());
		asset.setAssetPrice(form.getAssetPrice());
		asset.setPurchaseDate(form.getPurchaseDate());
		asset.setUsedTerm(form.getUsedTerm());
		asset.setUserId(principal.getName());
		boolean result = assetService.updateOne(asset);
		if (result) {
			model.addAttribute("result", "更新成功");
		} else {
			model.addAttribute("result", "更新失敗");
		}
		return getAssetList(model, principal);
	}

	@PostMapping(value = "/assetDetail", params = "delete")
	public String postAssetDetailDelete(@ModelAttribute AssetRegistrationForm form, Model model, Principal principal) {
		System.out.println("削除ボタンの処理");
		boolean result = assetService.deleteOne(form.getAssetId(), principal.getName());
		if (result) {
			model.addAttribute("result", "削除成功");
		} else {
			model.addAttribute("result", "削除失敗");
		}
		return getAssetList(model, principal);
	}

}
