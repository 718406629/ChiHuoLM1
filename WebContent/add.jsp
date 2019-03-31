<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddAddressServlet" method="post" onsubmit="return check()">
       联系人：<input type="text" name="userName" id="userName" ><br/>
       联系电话：<input type="text" name="phone" id="phone"><br/>
       省：<input type="text" name="province" id="province"><br/>
       市：<input type="text" name="city" id="city"><br/>
       区：<input type="text" name="area" id="area"><br/>
       详细地址：<input type="text" name="detail" id="detail"><br/>
     <input style="display:none;" ></input>
       
  <input type="submit" value="新增"><br/>
  <a href="QueryAllAddressServlet">返回</a><br/>


</form>
<script>
//判断用户是否登录



</script>	
</body>
</html>