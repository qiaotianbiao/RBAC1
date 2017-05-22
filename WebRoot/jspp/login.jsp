<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSPTest page. <br>
    <form  action="LoginServlet" method="post">
						<div >
							学号：<input type="text"  placeholder=" username"
								name="idCard" required="">
						</div>
						<div>
							密码：<input type="password" 
								placeholder="password" name="password" required="">
						</div>
						<% String error=(String)request.getAttribute("error");
      						if(error != null){%>
    							<div class="form-group" style="color: red">用户名或密码错误</div>
   						<% } %>    
						<button type="submit">登录</button>
		
					</form>
    
    
  </body>
</html>
