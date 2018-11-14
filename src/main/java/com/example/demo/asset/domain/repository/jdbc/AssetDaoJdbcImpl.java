package com.example.demo.asset.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.repository.AssetDao;

@Repository("AssetDaoJdbcImpl")
public class AssetDaoJdbcImpl implements AssetDao{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insertOne(Asset asset) throws DataAccessException {
		String sql ="insert into m_asset (asset_name,purchase_date,used_term,user_id)values(?,?,?,?)";
		int rowNumber=jdbc.update(sql,asset.getAssetName(),asset.getPurchaseDate(),asset.getUsedTerm(),"yamada@xxx.co.jp");;
		return rowNumber;
	}

	@Override
	public Asset selectOne(Long assetId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Asset> selectMany() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int updateOne(Asset asset) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int deleteOne(Long assetId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
