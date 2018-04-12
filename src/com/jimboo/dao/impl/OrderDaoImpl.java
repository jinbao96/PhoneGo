package com.jimboo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.OrderDao;
import com.jimboo.entity.Order;
import com.jimboo.entity.QueryOrder;
import com.jimboo.util.DBhelper;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class OrderDaoImpl implements OrderDao {
	private JdbcTemplate jt=new JdbcTemplate();
	@Override
	public int insert(int user_id, int goods_id, int cart_id, int quantity, long order_number, String address) {
		System.out.println(user_id);
		System.out.println(goods_id);
		System.out.println(quantity);
		System.out.println(order_number);
		System.out.println(cart_id);
		System.out.println(address);
		Connection conn = DBhelper.getConn();
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		PreparedStatement pst3=null;
		try {
			conn.setAutoCommit(false);
			pst1=conn.prepareStatement("insert into a_order values (order_id_seq.nextval,?,?,?,sysdate,?,?,0,?)");
			pst1.setInt(1, user_id);
			pst1.setInt(2, goods_id);
			pst1.setLong(3, order_number);
			pst1.setString(4, address);
			pst1.setInt(5, quantity);
			pst1.setString(6, "订单已提交,等待商家处理");
			int i = pst1.executeUpdate();
			pst2=conn.prepareStatement("update a_goods set count=count-?,status=status+? where goods_id=?");
			pst2.setInt(1, quantity);
			pst2.setInt(2, quantity);
			pst2.setInt(3, goods_id);
			int j = pst2.executeUpdate();
			pst3=conn.prepareStatement("update a_cart set isuse=1 where cart_id=?");
			pst3.setInt(1, cart_id);
			int k = pst3.executeUpdate();
			if(i>0&&j>0&&k>0) {
				conn.commit();
				return 1;
			}else {
				conn.rollback();
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBhelper.close(null, pst1, null);
			DBhelper.close(null, pst2, null);
			DBhelper.close(null, pst3, conn);
		}
		return -1;
	}

	@Override
	public List<Order> query(long order_number) {
		String sql="select * from order_view where order_number=?";
		List<Order> list = jt.query(sql, new RowMapper<Order>() {

			@Override
			public Order getInstance(ResultSet rs) throws SQLException {
				Order order=new Order();
				System.out.println(rs.getString("order_date"));
				order.setQuantity(rs.getInt("quantity"));
				order.setGname(rs.getString("gname"));
				order.setDate(rs.getString("order_date"));
				order.setUrl(rs.getString("url"));
				order.setOrder_num(rs.getLong("order_number"));
				order.setPrice(rs.getDouble("price"));
				order.setGoods_id(rs.getInt("goods_id"));
				order.setTotal(rs.getDouble("total"));
				order.setAddress(rs.getString("address"));
				order.setTest(rs.getString("test"));
				System.out.println(order);
				return order;
			}
		},order_number);
		return list;
	}
	
	
	@Override
	public int insertNocart(int user_id, int goods_id, int quantity, long order_number, String address) {
		Connection conn = DBhelper.getConn();
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		try {
			conn.setAutoCommit(false);
			pst1=conn.prepareStatement("insert into a_order values (order_id_seq.nextval,?,?,?,sysdate,?,?,0,?)");
			pst1.setInt(1, user_id);
			pst1.setInt(2, goods_id);
			pst1.setLong(3, order_number);
			pst1.setString(4, address);
			pst1.setInt(5, quantity);
			pst1.setString(6, "订单已提交,等待商家处理");
			int i = pst1.executeUpdate();
			pst2=conn.prepareStatement("update a_goods set count=count-?,status=status+? where goods_id=?");
			pst2.setInt(1, quantity);
			pst2.setInt(2, quantity);
			pst2.setInt(3, goods_id);
			int j = pst2.executeUpdate();
			if(i>0&&j>0) {
				conn.commit();
				return 1;
			}else {
				conn.rollback();
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBhelper.close(null, pst1, null);
			DBhelper.close(null, pst2, conn);
		}
		return -1;
	}

	@Override
	public List<QueryOrder> queryAll() {
		String sql="select DISTINCT order_number,ORDER_DATE,test from order_view order by ORDER_DATE desc";
		List<QueryOrder> list = jt.query(sql, new RowMapper<QueryOrder>() {

			@Override
			public QueryOrder getInstance(ResultSet rs) throws SQLException {
				QueryOrder order=new QueryOrder();
				order.setOrder_num(rs.getLong("order_number"));
				order.setOrder_date(rs.getString("order_date"));
				order.setTest(rs.getString("test"));
				return order;
			}
		});
		return list;
	}

	@Override
	public double queryMoney(String date) {
		//System.out.println(date);
		String sql = "select sum(total) as money from order_view where order_date like ?";
		Connection conn = DBhelper.getConn();
		PreparedStatement pst=null;
		double money = 0;
		try {
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql);
			pst.setString(1, date+"%");
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs.next());
			//System.out.println("111" + rs.getDouble(1));
			boolean flag = rs.next();
			if(flag) {
				money = rs.getDouble(1);
			}
			//System.out.println(money);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return money;
	}

}
