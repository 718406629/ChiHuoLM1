package org.address.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.entity.Address;
import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;




public class QueryAllAddressServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	IaddressService iaddressService=new addressServiceImpl();

	List<Address> addresses=iaddressService.queryAllAddress();
	//临时打印在控制台里面
	System.out.println(addresses);//参数为对象名时 默认调用该对象的toString（）方法
	
	request.setAttribute("addresses", addresses);
	//因为request域中有数据，因此需要通过请求的方式跳转（重定向会丢失request域）
	//pageContext<request<session<application
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
