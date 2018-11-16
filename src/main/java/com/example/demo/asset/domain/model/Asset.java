package com.example.demo.asset.domain.model;

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
}
