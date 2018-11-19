package com.example.demo.asset.domain.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.Data;

@Data
public class Asset {
	private Long assetId;
	private int assetPrice;
	private String assetName;
	private Date purchaseDate;
	private int usedTerm;
	private String userId;

	/**
	 * 減価償却完了月
	 * @return
	 */
	public Date getPurchaseEndDate() {
		//	TODO:	汚いので後で直したい
		//		Date型をLocalDate型に変換
		LocalDate purchaseLocalDate = purchaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		purchaseLocalDate = purchaseLocalDate.plusMonths(usedTerm);
		//		LocalDate型をDate型に変換
		Date purchaseEndDate = Date.from(purchaseLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return purchaseEndDate;
	}
	public int getMonthlyCost() {
		return assetPrice/usedTerm;
	}
}
