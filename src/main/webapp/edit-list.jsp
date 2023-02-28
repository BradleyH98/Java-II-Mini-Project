<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Inventory Report</title>
</head>
<body>
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${reportToEdit.id}">
	Report Name: <input type ="text" name = "reportName" value= "${reportToEdit.inventoryName}"><br />
	Report date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}">
		<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">
		<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	Dealer Name: <input type = "text" name = "dealerName" value="${reportToEdit.cardealers.dealerName}"><br />
	Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.id}">${currentitem.vehicleModel} | ${currentitem.vehicleYear} | ${currentitem.price}</option>
	</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>