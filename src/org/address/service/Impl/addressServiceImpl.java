package org.address.service.Impl;

import java.util.List;

import org.address.Dao.IaddressDao;
import org.address.Dao.Impl.addressDaoImpl;
import org.address.entity.Address;
import org.address.service.IaddressService;


public class addressServiceImpl implements IaddressService {
	IaddressDao iaddressDao= new addressDaoImpl();
	
	
	// 查询所有的地址信息
		public List<Address> queryAllAddress(){
			return iaddressDao.queryAllAddress();
			
		}

	// 根据地址编号 查询此信息是否存在
		public boolean isExist(int addressId) {
			return iaddressDao.isExist(addressId);
		}

		// 增加地址信息信息
		public boolean addAddress(Address address) {
			if(!iaddressDao.isExist(address.getAddressId())) {
				return iaddressDao.addAddress(address);
			}else {
				return false;
			}
		}

		// 根据地址编号，修改信息
		public boolean updateAddressByAddressId(int addressId, Address address) {
			if(iaddressDao.isExist(addressId)) {
				return iaddressDao.updateAddressByAddressId(addressId, address);
			}else {
				return false;
			}
			
		}

		// 根据地址编号，删除信息
		public boolean deleteAddressByAddressId(int addressId) {
			if(iaddressDao.isExist(addressId)) {
				return iaddressDao.deleteAddressByAddressId(addressId);
			}else {
				return false;
			}
			
		}

		// 根据地址编号查询信息
		public Address queryAddressByAddressId(int addressId) {
			return iaddressDao.queryAddressByAddressId(addressId);
		}

		// 查询总数据数
		public int getTotalCount() {
			return iaddressDao.getTotalCount();
			
		}

		// currentPage:当前页（页码）pageSize:页面大小（每页显示数据量）
		public List<Address> queryAddressByPage(int currentPage, int pageSize){
			return iaddressDao.queryAddressByPage(currentPage, pageSize);
		}
}
