package org.address.Dao;

import java.util.List;

import org.address.entity.Address;


public interface IaddressDao {
	// 查询所有的地址信息
	public List<Address> queryAllAddress();

// 根据地址编号 查询此信息是否存在
	public boolean isExist(int addressId);

	// 增加地址信息信息
	public boolean addAddress(Address address);

	// 根据地址编号，修改信息
	public boolean updateAddressByAddressId(int sno, Address address);

	// 根据地址编号，删除信息
	public boolean deleteAddressByAddressId(int addressId);

	// 根据地址编号查询信息
	public Address queryAddressByAddressId(int addressId);

	// 查询总数据数
	public int getTotalCount();

	// currentPage:当前页（页码）pageSize:页面大小（每页显示数据量）
	public List<Address> queryAddressByPage(int currentPage, int pageSize);
}
