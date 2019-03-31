package org.address.entity;
public class Address {
        //备注
	private int addressId;//地址编号
	private String userName;//联系人
	private String phone;//联系电话
	private String province;//省
	private String city;//市
	private String area;//区
	private String detail;//详情地址
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Address(int addressId, String userName, String phone, String province, String city, String area,
			String detail) {
		
		this.addressId = addressId;
		this.userName = userName;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.area = area;
		this.detail = detail;
		
	}
	public Address() {
		
	}
	public String toString() {
		
		return this.addressId+"-"+this.userName+"-"+this.phone+"-"+this.province+"-"+this.city+"-"+this.area+"-"+this.detail;
		
		
	}
	
	
}
