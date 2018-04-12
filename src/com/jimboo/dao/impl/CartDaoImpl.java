package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.CartDao;
import com.jimboo.entity.Cart;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class CartDaoImpl implements CartDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<Cart> mapper=new RowMapper<Cart>() {

		@Override
		public Cart getInstance(ResultSet rs) throws SQLException {
			Cart cart=new Cart();
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setGoods_id(rs.getInt("goods_id"));
			cart.setUser_id(rs.getInt("user_id"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setTotal(rs.getDouble("total"));
			cart.setIsuse(rs.getInt("isuse"));
			return cart;
		}
	};
	@Override
	public List<Cart> queryCart(int user_id, int goods_id) {
		String sql="select * from a_cart where user_id=? and goods_id=? and isuse=0";
		return jt.query(sql, mapper, user_id,goods_id);
	}
	@Override
	public int updateCartAdd(Cart cart) {
		String sql="update a_cart set quantity=quantity+?,total=total+? where user_id=? and goods_id=? and isuse=0";
		int i = jt.update(sql, cart.getQuantity(),cart.getTotal(),cart.getUser_id(),cart.getGoods_id());
		return i;
	}
	@Override
	public int queryCartGoods(Cart cart) {
		String sql="insert into a_cart values (cart_id_seq.nextval,?,?,?,?,0)";
		return jt.update(sql, cart.getUser_id(),cart.getGoods_id(),cart.getQuantity(),cart.getTotal());
	}
	@Override
	public List<Cart> queryCartByUid(int user_id) {
		String sql="select * from cart_view where user_id=?";
		return jt.query(sql, new RowMapper<Cart>() {

			@Override
			public Cart getInstance(ResultSet rs) throws SQLException {
				Cart cart=new Cart();
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setGoods_id(rs.getInt("goods_id"));
				cart.setUser_id(rs.getInt("user_id"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setTotal(rs.getDouble("total"));
				cart.setUrl(rs.getString("url"));
				cart.setGoods_name(rs.getString("gname"));
				cart.setPrice(rs.getDouble("price"));
				cart.setCount(rs.getInt("count"));
				return cart;
			}
		}, user_id);
	}
	@Override
	public int delCartById(int user_id, int cart_id) {
		String sql="update a_cart set isuse=1 where user_id=? and cart_id=?";
		int i = jt.update(sql, user_id,cart_id);
		return i;
	}

}
