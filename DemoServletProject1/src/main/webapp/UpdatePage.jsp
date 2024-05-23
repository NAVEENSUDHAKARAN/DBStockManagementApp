<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.dao.ServerManager"%>
<%@page import="com.chainsys.servlet.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<style>

#mainDiv{
	width: 50%;
	heigth: 50%;
	position: absolute;
	top: 20%;
	left: 25%
}

</style>
<body>
	<% ServerManager server = new ServerManager();
	ArrayList<UserDetails> arrList = server.getUserDetails();
	for (UserDetails user : arrList) {%>
	
	<div id="mainDiv">
		<form action="FirstServlet" method="post">
			<input type="hidden" name="action" value="update" >
			<input type="text" name="upName" placeholder="Enter The Name to Update"  >
			<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
			<input type="hidden" name="upName" value="<%=user.getUpdatedName()%>">
			<input type="submit" value="Ok">
		</form>
		
	</div>
	
	<% }%>
</body>
</html>