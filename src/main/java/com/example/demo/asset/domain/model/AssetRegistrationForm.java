package com.example.demo.asset.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AssetRegistrationForm {
	private Long assetId;
	@NotBlank
	private String assetName;
	@NotNull
	private int assetPrice;
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date purchaseDate;
	@NotNull
	private int usedTerm;
}
