package com.example.demo.asset.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.asset.domain.model.Asset;

public interface AssetDao {
	public int insertOne(Asset asset) throws DataAccessException;

	public Asset selectOne(Long assetId,String userId) throws DataAccessException;

	public List<Asset> selectMany(String userId) throws DataAccessException;

	public int updateOne(Asset asset) throws DataAccessException;

	public int deleteOne(Long assetId,String userId) throws DataAccessException;

}
