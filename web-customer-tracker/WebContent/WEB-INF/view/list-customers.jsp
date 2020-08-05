<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>

<input type="button" value="Add Customer" onclick="window.location.href='showFormAdd';return false;"/>

<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email Name</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="customer" items="${customers}">
		
		<c:url var="updateLink" value="/customer/showFormUpdate">
			<c:param name="customerId" value="${customer.id }"></c:param>
		</c:url>
		
		<c:url var="deleteLink" value="/customer/deleteCustomer">
			<c:param name="customerId" value="${customer.id }"></c:param>
		</c:url>
	
		<tr> 
			<td>${customer.firstName}</td>
			<td>${customer.lastName}</td>
			<td>${customer.email}</td>
			<td><a href="${updateLink}">Update</a> 
			| 
			<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>