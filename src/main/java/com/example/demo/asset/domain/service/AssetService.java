package com.example.demo.asset.domain.service;

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

	public Asset selectOne(Long assetId,String userId) {
		return dao.selectOne(assetId, userId);
	}

	public boolean updateOne(Asset user) {
		int rowNumber =dao.updateOne(user);
		boolean result =false;
		if(rowNumber>0) {
			result=true;
		}
		return result;
	}

	public boolean deleteOne(Long assetId,String userId) {
		int rowNumber=dao.deleteOne(assetId, userId);
		boolean result=false;
		if (rowNumber>0) {
			result=true;
		}
		return result;
	}

}
