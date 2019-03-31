package org.address.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.entity.Address;
import org.address.entity.Page;
import org.address.service.IaddressService;
import org.address.service.Impl.addressServiceImpl;





public class QueryAddressByPageServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    IaddressService iaddressService=new addressServiceImpl();
	int count = iaddressService.getTotalCount() ;//数据总数
	
	//将分页所需的5个字段（其中有1个自动计算，因此实际只需要组装4个即可），组装到page对象之中
	Page page = new Page();
	
	
	String cPage = request.getParameter("currentPage")  ;//
	

	
	if(cPage == null) {
		cPage = "1" ;
	}
	

	
	int currentPage = Integer.parseInt( cPage );
	page.setCurrentPage(currentPage);
//	int currentPage = 2;//页码
	
	//注意 顺序
	int totalCount = iaddressService.getTotalCount() ;//总数据数
	page.setTotalCount(totalCount);
	
	/* currentPage：当前页（页码）  
  	 students :当前页的数据集合（当前页的所有学生）
	
	*/
	String pagesize=(String)request.getParameter("pagesize");
	if(pagesize==null) {
		pagesize="3";
	}
	int pageSize =Integer.parseInt(pagesize);
	page.setPageSize(pageSize);
	List<Address>  addresses=iaddressService.queryAddressByPage(currentPage, pageSize);
	System.out.println(addresses);
	System.out.println(count);
	

	
	page.setAddresses(addresses);
	request.setAttribute("p", page);
	request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
