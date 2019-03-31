<%@page import="org.address.entity.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <c:forEach var="address" items="${requestScope.address }">
     
    
<form action="UpdateAddressByAddressIdServlet">
           地址编号：<input type="text" name="addressId" value="${address.addressId }" ><br/>
       联系人：<input type="text" name="userName" value="${address.userName }"  ><br/>
       联系电话：<input type="text" name="phone" value="${address.phone } %>" ><br/>
       省：<input type="text" name="province"  value="${address.province" ><br/>
       市：<input type="text" name="city"  value="${address.city }" ><br/>
       区：<input type="text" name="area"  value="${address.area }" ><br/>
       详细地址：<input type="text" name="detail" value="${address.detail }" ><br/>
     <input type="submit" value="修改">
     <a href="QueryAllAddressServlet">返回</a>
    


</form>
 </c:forEach>

</body>
</html>