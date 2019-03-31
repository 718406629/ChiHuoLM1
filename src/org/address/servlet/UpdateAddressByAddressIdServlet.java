package org.address.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.entity.Address;
import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;



public class UpdateAddressByAddressIdServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 处理编码
	request.setCharacterEncoding("UTF-8");
	// 拿到从jsp页面传来的数据
	 int addressId=Integer.parseInt(request.getParameter("addressId"));
		String userName=request.getParameter("userName");
		String phone=request.getParameter("phone");
		String province=request.getParameter("province");
	    String city=request.getParameter("city");
	    String area= request.getParameter("area");
	    String detail=request.getParameter("detail");
	    String userId=request.getParameter("userId");

	// 封装成Javabean
	    Address address=new Address(addressId,userName,phone,province,city,area,detail);
	// 调用业务逻辑层：修改的方法（查+修改）
	IaddressService iaddressService=new addressServiceImpl();
	boolean result = iaddressService.updateAddressByAddressId(addressId, address);
	//设置响应时的字符编码
	response.setContentType("text/html; charset=UTF-8");// 浏览器识别编码html
	response.setCharacterEncoding("utf-8");
	if (result) {

		//response.getWriter().print("修改成功！");
		response.sendRedirect("QueryAllAddressServlet");
	} else {

		response.getWriter().print("修改失败！");
	}

	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
