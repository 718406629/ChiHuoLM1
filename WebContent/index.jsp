<%@page import="org.address.entity.Address"%>
<%@page import="java.util.List"%>
<%@page import="org.address.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
    <tr>
    <th>地址编号</th>
    <th>联系人</th>
    <th>联系电话</th>
    <th>操作</th>
    </tr>
      <%
          List<Address> addresses=(List<Address>)request.getAttribute("addresses");
          for(Address address:addresses){
     
        	  
        	  
      %>
         <tr>
         <td><a href="QueryAddressByAddressIdServlet?addressId=<%=address.getAddressId() %>"><%=address.getAddressId() %></a></td>
         <td><%=address.getUserName() %></td>
         <td><%=address.getPhone()%></td>
         <td><a href="DeleteAddressByAddressIdServlet?addressId=<%=address.getAddressId() %>">删除</a></td>
         </tr>
      
<% 
}
          %>
</table>
<a href="add.jsp">增加</a>

	   
</body>
</html>