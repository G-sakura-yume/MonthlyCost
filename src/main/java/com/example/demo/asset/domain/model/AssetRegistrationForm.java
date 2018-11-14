package com.example.demo.asset.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class AssetRegistrationForm {
	private String assetName;
	private Date purchaseDate;
	private int usedTerm;
}
