package org.address.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.entity.Address;
import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;



public class AddAddressServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		    IaddressService iaddressService=new addressServiceImpl();

		    int addressId=iaddressService.getTotalCount()+1;
			String userName=request.getParameter("userName");
			String phone=request.getParameter("phone");
			String province=request.getParameter("province");
		    String city=request.getParameter("city");
		    String area= request.getParameter("area");
		    String detail=request.getParameter("detail");
	
		 

		    Address address=new Address(addressId,userName,phone,province,city,area,detail);
			boolean result=iaddressService.addAddress(address);
			//response响应编码设置----》解决乱码问题
			response.setContentType("text/html; charset=UTF-8");//浏览器识别编码html
			response.setCharacterEncoding("utf-8");//设置自身编码
			if(result) {
			request.getRequestDispatcher("QueryAllAddressServlet").forward(request, response);
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
