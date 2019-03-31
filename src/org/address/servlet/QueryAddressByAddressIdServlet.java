package org.address.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.entity.Address;
import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;



public class QueryAddressByAddressIdServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int addressId=Integer.parseInt(request.getParameter("addressId"));
	IaddressService iaddressService=new addressServiceImpl();
	Address address=iaddressService.queryAddressByAddressId(addressId);
	//System.out.println(student);//默认会调用student里的toString()方法。
	request.setAttribute("address", address);
	//有数据 用转发 无数据 用重定向
	request.getRequestDispatcher("AddressInfo.jsp").forward(request, response);
		}

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
