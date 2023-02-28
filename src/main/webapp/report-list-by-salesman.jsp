<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
			<td><input type="radio" name="id" value="${currentlist.id}"></td>
			<td><h2>${currentlist.reportName}</h2></td></tr>
			<tr><td colspan="3">Report Date: ${currentlist.inventoryDate}</td></tr>
			<tr><td colspan="3">Dealer: ${currentlist.cardealers.dealerName}</td></tr>
			<c:forEach var = "listVal" items = "${currentlist.listOfCars}">
				<tr><td></td><td colspan="3">
					${listVal.vehicleModel}, ${listVal.vehicleYear}, ${listVal.price}
					</td>
				</tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="addItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>