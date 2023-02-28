<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory List</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
	<table>
		<tr>
			<th>Object Select</th>
			<th>Vehicle Model</th>
			<th>Vehicle Year</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${requestScope.showAllItems}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.id}"></td>
				<td>${currentitem.vehicleModel}</td>
				<td>${currentitem.vehicleYear}</td>
				<td>${currentitem.price}</td>
			</tr>
		</c:forEach>
	</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>