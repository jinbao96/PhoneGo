package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.GoodsDao;
import com.jimboo.entity.Goods;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.Page;
import com.jimboo.util.RowMapper;

public class GoodsDaoImpl implements GoodsDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<Goods> mapper=new RowMapper<Goods>() {

		@Override
		public Goods getInstance(ResultSet rs) throws SQLException {
			Goods goods=new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setCategory_id(rs.getInt("category_id"));
			goods.setGname(rs.getString("gname"));
			goods.setInfo(rs.getString("info"));
			goods.setPrice(rs.getDouble("price"));
			goods.setCount(rs.getInt("count"));
			goods.setUrl(rs.getString("url"));
			goods.setStatus(rs.getInt("status"));
			goods.setIsuse(rs.getInt("isuse"));
			return goods;
		}
	};
	@Override
	public List<Goods> queryAllGoods() {
		String sql="select * from a_goods order by 1";
		return jt.query(sql, mapper);
	}
	@Override
	public List<Goods> queryGoodsPage(Page page) {
		String sql="SELECT * FROM(SELECT ROWNUM rn,g.* FROM(select * from a_goods order by goods_id) g where ROWNUM<=?) WHERE rn>=?";
		return jt.query(sql, mapper, page.getEnd(),page.getBegin());
	}
	@Override
	public Goods queryById(int goods_id) {
		String sql="select * from goodsinfo where goods_id=?";
		return jt.query(sql, new RowMapper<Goods>() {

			@Override
			public Goods getInstance(ResultSet rs) throws SQLException {
				Goods goods=new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setCategory_id(rs.getInt("category_id"));
				goods.setGname(rs.getString("gname"));
				goods.setInfo(rs.getString("info"));
				goods.setPrice(rs.getDouble("price"));
				goods.setCount(rs.getInt("count"));
				goods.setUrl(rs.getString("url"));
				goods.setStatus(rs.getInt("status"));
				goods.setIsuse(rs.getInt("isuse"));
				goods.setCategory_name(rs.getString("category_name"));
				return goods;
			}
		}, goods_id).get(0);
	}
	@Override
	public List<Goods> queryByGname(String gname) {
		String sql="select * from a_goods where gname like ? order by 1";
		return jt.query(sql, mapper, "%"+gname+"%");
	}
	@Override
	public List<Goods> queryByGnamePage(String gname, Page page) {
		String sql="SELECT * FROM(SELECT ROWNUM rn,g.* FROM(select * from a_goods where gname like ? order by goods_id) g where ROWNUM<=?) WHERE rn>=?";
		return jt.query(sql, mapper,"%"+gname+"%",page.getEnd(),page.getBegin());
	}
	@Override
	public List<Goods> queryByCid(int category_id) {
		String sql="select * from a_goods where category_id=? order by 1";
		return jt.query(sql, mapper, category_id);
	}
	@Override
	public List<Goods> queryByCidPage(int category_id, Page page) {
		String sql="SELECT * FROM(SELECT ROWNUM rn,g.* FROM(select * from a_goods where category_id=? order by goods_id) g where ROWNUM<=?) WHERE rn>=?";
		return jt.query(sql, mapper, category_id,page.getEnd(),page.getBegin());
	}
	
	@Override
	public List<Goods> queryHot() {
		String sql="SELECT ROWNUM rn,g.* FROM(select * from a_goods order by status desc) g where ROWNUM<=5";
		return jt.query(sql, mapper);
	}
	@Override
	public int addGoods(Goods g) {
		String sql = "insert into a_goods values (goods_id_seq.nextval,?,?,?,?,?,?,?,?)";
		return jt.update(sql, g.getCategory_id(),g.getGname(),g.getInfo(),g.getPrice(),g.getCount(),g.getUrl(),g.getStatus(),g.getIsuse());
	}
	@Override
	public int del(int goods_id) {
		String sql = "DELETE FROM a_goods WHERE goods_id=?";
		return jt.update(sql, goods_id);
	}
	@Override
	public int changeGoods(Goods g) {
		String sql = "update a_goods set gname=?,price=?,info=?,count=? where goods_id=?";
		return jt.update(sql, g.getGname(),g.getPrice(),g.getInfo(),g.getCount(),g.getGoods_id());
	}

}
