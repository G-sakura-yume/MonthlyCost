package com.example.demo.asset.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.asset.domain.model.Asset;

public interface AssetDao {
	public int insertOne(Asset asset) throws DataAccessException;

	public Asset selectOne(Long assetId) throws DataAccessException;

	public List<Asset> selectMany() throws DataAccessException;

	public int updateOne(Asset asset) throws DataAccessException;

	public int deleteOne(Long assetId) throws DataAccessException;

}
