<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
  function display_alert1()
  {
  var myName="<%=session.getAttribute("action")%>"; 
  if(myName==1||myName==3)
  alert("I have the power to A!!")
  else
  alert("I have no power")
  }
</script>
	<script type="text/javascript">
  function display_alert2()
  {
  var myName="<%=session.getAttribute("action")%>"; 
  if(myName==2||myName==3)
  alert("I have the power to B!!")
  else
  alert("I have no power")
  }
</script>
	
	
  </head>
  
  <body>
  <br>I am :<%=session.getAttribute("username")%></br>
 <input type="button" onclick="display_alert1()"
 value="A" /> 
  <input type="button" onclick="display_alert2()"
 value="B" /> 
 
					
				
    
    
  </body>
</html>
