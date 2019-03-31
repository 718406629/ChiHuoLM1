package org.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;


public class DeleteAddressByAddressIdServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//删除
			request.setCharacterEncoding("utf-8");
			//接受前端传来的学号
			int addressId=Integer.parseInt(request.getParameter("addressId"));
			
			//调用业务逻辑层
		    IaddressService iaddressService=new addressServiceImpl();
			boolean result=iaddressService.deleteAddressByAddressId(addressId);
	    	response.setContentType("text/html; charset=UTF-8");//浏览器识别编码html
			response.setCharacterEncoding("utf-8");//设置自身编码
	    	PrintWriter out=response.getWriter();

			if(result) {
				
				//out.print("删除成功！");
				response.sendRedirect("QueryAllAddressServlet");
				
				
			}else {
			     out.print("删除失败！");
			}
			
			
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
