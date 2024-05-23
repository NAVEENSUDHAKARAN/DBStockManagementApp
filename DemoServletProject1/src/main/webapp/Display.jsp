<%@page import="com.chainsys.dao.ServerManager"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.servlet.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<style>
#table {
	position: relative;
	left: 5%;
	top: 9%;
	width: 80%;
	height: 80%;
	justify-self: center;
	border-radius: 3px;
}

#table:hover {
	cursor: pointer;
}

#btns {
	position: absolute;
	left: 85%;
	top: 30%;
	gap: 10px;
}

#addBtn {
	background-color: #0057ff;
	border: none;
	color: black;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

#addBtn:hover {
	background: white;
	color: maroon;
}

#addText:hover {
	color: black;
}

#updateBtn {
	background-color: #0057ff;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

#updateBtn:hover {
	background: white;
	color: black;
}

#deleteBtn {
	background-color: #0057ff;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

#deleteBtn:hover {
	background: white;
	color: black;
}
</style>
<body>
	<h1 style="padding-left: 500px">User Details</h1>

	<table id="table" border="1">
		<tr style="background-color: #0057ff; color: white;">
			<td>Name</td>
			<td>DOB</td>
			<td>EmployeeID</td>
		</tr>
		<%
		ServerManager server = new ServerManager();
		ArrayList<UserDetails> arrList = server.getUserDetails();
		for (UserDetails user : arrList) {
			
		%>
		<tr style="background-color: white">
			<td><%=user.getName()%></td>
			<td><%=user.getDOB()%></td>
			<td><%=user.getEmpId()%></td>
			<td>
				<form action="FirstServlet" method="post">
					<input type="hidden" name="action" value="delete"> 
					<input type="hidden" name="id" value="<%=user.getEmpId()%>">
					<input type="hidden" name="Name" value="<%=user.getName()%>"> 
					<input id="deleteBtn" onclick="alert(Successfully Deleted!!!)" type="submit" value="Delete">
				</form>
			</td>
			<td>
					<input type="hidden" name="id" value="<%=user.getEmpId()%>"> 
					<input id="updateBtn" onclick="window.location.href='UpdatePage.jsp?id=<%= user.getEmpId() %>'" type="button" value="Update">
			</td>	

		</tr>

		<%
		}
		%>
	</table>
	<div id="btns">
		<button id="addBtn">
			<a id="addText" style="text-decoration: none;"
				href="RegistrationForm.html">Add</a>
		</button>
		<br>
		<br>

	</div>
</body>
<script>
	
</script>

</html>