package com.example.demo.asset.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.asset.domain.model.Asset;
import com.example.demo.asset.domain.repository.AssetDao;

@Repository("AssetDaoJdbcImpl")
public class AssetDaoJdbcImpl implements AssetDao{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insertOne(Asset asset) throws DataAccessException {
		String sql ="insert into m_asset (asset_name,asset_price,purchase_date,used_term,user_id)values(?,?,?,?,?)";
		return jdbc.update(sql,asset.getAssetName(),asset.getAssetPrice(),asset.getPurchaseDate(),asset.getUsedTerm(),asset.getUserId());
	}

	@Override
	public Asset selectOne(Long assetId,String userId) throws DataAccessException {
		RowMapper<Asset> rowMapper=new BeanPropertyRowMapper<Asset>(Asset.class);
		String sql="select * from m_asset as m where m.asset_id=? and m.user_id=?";
		return jdbc.queryForObject(sql, rowMapper,assetId,userId);
	}

	@Override
	public List<Asset> selectMany(String userId) throws DataAccessException {
		String sql="select * from m_asset as m where m.user_id=?";
		RowMapper<Asset> rowMapper=new BeanPropertyRowMapper<Asset>(Asset.class);
		return jdbc.query(sql,rowMapper,userId);
	}

	@Override
	public int updateOne(Asset asset) throws DataAccessException {
		String sql="update m_asset set asset_name =?,asset_price=?,purchase_date=?,used_term=? where asset_id=? and user_id =?";
		return jdbc.update(sql,asset.getAssetName(),asset.getAssetPrice(),asset.getPurchaseDate(),asset.getUsedTerm(),asset.getAssetId(),asset.getUserId());
	}

	@Override
	public int deleteOne(Long assetId,String userId) throws DataAccessException {
		String sql="delete from m_asset where asset_id=? and user_id=?";
		return jdbc.update(sql,assetId,userId);
	}

}
