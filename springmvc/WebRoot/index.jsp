<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#json").click(function(){
				$.getJSON("json.do",{"customerid":"100"},function(data){
					alert("success");
				})
			})
		})
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<a href="hello2.do">Hello World</a>
  	<br><br>
  	
  	<a href="edit.do?customerid=100">edit</a>
  	<br><br>
  	
  	<a href="json.do" id="json">test json request</a>
  	<br><br>
  	
  	<form action="add.do" method="post">
  		customerName:<input type="text" name="customerName"/><br>
  		email:<input type="text" name="email"/><br>
  		<input type="submit" value="Submit"/>
  	</form>
  	<br><br>
  	
  	<a href="testRequest.do?time=<%=new Date() %>">testRequest...</a>
  	<br><br>
  	
  	<a href="testInputStreamAndOutputStream.do">testInputStreamAndOutputStream...</a>
  	<br><br>
  	
  	<form action="testInputStreamAndOutputStream.do" method="post" enctype="multipart/form-data">
 		customerName:<input type="text" name="customerName"/><br>
 		file:<input type="file" name="file"/><br>
 		<input type="submit" value="Submit"/>
 	</form>
 	
 	<a href="testModelAndView.do?customerid=100">testModelAndView...</a>
 	<br><br>
 	
 	<form action="testModelAttribute.do" method="post">
  		customerName:<input type="text" name="customerName"/><br>
  		email:<input type="text" name="email"/><br>
  		<input type="submit" value="Submit"/>
  	</form>
  	<br><br>
  	
  	add2
  	<form action="add2.do" method="post">
  		customerName:<input type="text" name="customerName"/><br>
  		email:<input type="text" name="email"/><br>
  		<input type="submit" value="Submit"/>
  	</form>
  </body>
</html>
