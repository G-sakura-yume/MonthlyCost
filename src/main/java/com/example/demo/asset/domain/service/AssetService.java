package com.example.demo.asset.domain.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.repository.AssetDao;

@Transactional
@Service
public class AssetService {
	@Autowired
	@Qualifier("AssetDaoJdbcImpl")
	AssetDao dao;

	public boolean insert(Asset asset) {
		int rowNumber = dao.insertOne(asset);
		boolean result = false;
		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

	public List<Asset> selectMany(String userId) {
		return dao.selectMany(userId);
	}

	public Asset selectOne(Long assetId, String userId) {
		return dao.selectOne(assetId, userId);
	}

	public boolean updateOne(Asset user) {
		int rowNumber = dao.updateOne(user);
		boolean result = false;
		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

	public boolean deleteOne(Long assetId, String userId) {
		int rowNumber = dao.deleteOne(assetId, userId);
		boolean result = false;
		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

	public int[] createGlafPoint(List<Asset> assetList) {
//	TODO:	この処理移動したい
		int point[] = new int[9];
		Calendar purchaseCal = Calendar.getInstance();
		Calendar purchaseEndCal = Calendar.getInstance();

		Calendar pointCal = Calendar.getInstance();
		int month = pointCal.get(Calendar.MONTH);
		int year = pointCal.get(Calendar.YEAR);
		pointCal.set(year, month - 4, 1, 0, 0, 0);

		for (int i = 0; i < 9; i++) {
			for (Asset asset : assetList) {
				purchaseCal.setTime(asset.getPurchaseDate());
				purchaseEndCal.setTime(asset.getPurchaseEndDate());
				if (pointCal.compareTo(purchaseCal) == 0 || pointCal.compareTo(purchaseCal) > 0) {
					if (pointCal.compareTo(purchaseEndCal) < 0) {
						point[i] += asset.getMonthlyCost();
					}
				}
				pointCal.add(Calendar.MONTH, 1);
			}
		}

		return point;
	}

	public String[] createGlafLabel() {
//		TODO:	この処理移動したい
		String label[] = new String[9];
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy年MM月");

		Calendar rabelCal = Calendar.getInstance();
		rabelCal.add(Calendar.MONTH, -4);

		for (int i = 0; i < 9; i++) {
			label[i]=sdf.format(rabelCal.getTime());
			rabelCal.add(Calendar.MONTH, 1);
		}

		return label;
	}

}
