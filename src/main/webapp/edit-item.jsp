<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit info</title>
</head>
<body>
	<form action = "editItemServlet" method="post">
	Vehicle Model: <input type ="text" name = "vehicleModel" value= "${itemToEdit.vehicleModel}">
	Vehicle Year: <input type = "text" name = "vehicleYear" value= "${itemToEdit.fishWeight}">
	Price: <input type = "text" name = "price" value= "${itemToEdit.river}">
	<input type = "hidden" name = "id" value="${itemToEdit.id}">
	<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>