package org.address.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.address.Dao.IaddressDao;
import org.address.entity.Address;
import org.address.util.DBUtil;


public class addressDaoImpl implements IaddressDao {

	// 查询所有的地址信息
	public List<Address> queryAllAddress() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Address> addresses=new ArrayList<Address>();
		String sql="select *from address";
	    rs=DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
			int addressId=rs.getInt("addressId");
			String userName=rs.getString("userName");
			String phone=rs.getString("phone");
			String province=rs.getString("province");
		    String city=rs.getString("city");
		    String area= rs.getString("area");
		    String detail=rs.getString("detail");
		     Address address=new Address(addressId,userName,phone,province,city,area,detail);
		     addresses.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBUtil.closeAll(rs,pstmt,DBUtil.connection);
		}
		return addresses;
		
		
		
	}

	// 根据地址编号 查询此信息是否存在
	public boolean isExist(int addressId) {
		//如果不存在 返回false 存在返回true
	return	queryAddressByAddressId(addressId)==null?false:true;
	
	};

	// 增加地址信息信息
	public boolean addAddress(Address address) {
		String sql="insert into address(addressId,userName,phone,province,city,area,detail) values(?,?,?,?,?,?,?)";
		Object[] params= {address.getAddressId(),address.getUserName(),address.getPhone(),address.getProvince(),address.getCity(),address.getArea(),address.getDetail()};
		return DBUtil.executeUpdate(sql, params);
	
	
	}

	// 根据地址编号，修改信息
	public boolean updateAddressByAddressId(int addressId, Address address) {
		String sql="update address set userName=?, phone=?,province=?,city=?,area=?,detail=? where addressId=?";
		Object[] params= {address.getUserName(),address.getPhone(),address.getProvince(),address.getCity(),address.getArea(),address.getDetail(),addressId};
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据地址编号，删除信息
	public boolean deleteAddressByAddressId(int addressId) {
		String sql="delete from address where addressId=?";
		Object[] params= {addressId};
		return DBUtil.executeUpdate(sql, params);
		
	}

	// 根据地址编号查询信息
	public Address queryAddressByAddressId(int addressId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from address where addressId=?";
		Object[] params= {addressId};
		rs=DBUtil.executeQuery(sql, params);
		Address address=null;
		try {
			while(rs.next()) {
			int addressid=rs.getInt("addressId");
			String userName=rs.getString("userName");
			String phone=rs.getString("phone");
			String province=rs.getString("province");
		    String city=rs.getString("city");
		    String area= rs.getString("area");
		    String detail=rs.getString("detail");
		    String userId=rs.getString("userId");

		    address=new Address(addressid,userName,phone,province,city,area,detail);
		    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBUtil.closeAll(rs, pstmt,DBUtil.connection);
		}
		return address;
		
		
		
	}

	// 查询总数据数
	public int getTotalCount() {
		String sql="select count(1) from address";
		return DBUtil.getTotalCount(sql);
	}

	
	// currentPage:当前页（页码）pageSize:页面大小（每页显示数据量）
	public List<Address> queryAddressByPage(int currentPage, int pageSize) {
		String sql="select *from address limit ?,? ";
		Object[] params= {(currentPage-1)*pageSize,pageSize};
		List<Address> addresses=new ArrayList<Address>();
		ResultSet rs=DBUtil.executeQuery(sql, params);
		
		try {
			while(rs.next()) {
			int addressid=rs.getInt("addressId");
			String userName=rs.getString("userName");
			String phone=rs.getString("phone");
			String province=rs.getString("province");
		    String city=rs.getString("city");
		    String area= rs.getString("area");
		    String detail=rs.getString("detail");
		    String userId=rs.getString("userId");

		 Address address=new Address(addressid,userName,phone,province,city,area,detail);
		  addresses.add(address) ; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBUtil.closeAll(rs, null, null);
		}
		return addresses;
		
		
	}



}
