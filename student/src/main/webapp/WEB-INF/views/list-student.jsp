<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Students Management Directory</title>
</head>

<body>
	<div class="container">
		<div class="row" style="margin-top: 10px; text-align: center;">
			<div class="col-11">
				<h3>Student Management Directory</h3>
			</div>
			<div class="col-1">
				<a href="/student/logout"
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a>
			</div>
		</div>
		<hr>
		<!--  table form -->
		<table class="table table-bordered table-striped">
			<thead class="thead-light">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Course</th>
					<th>Country</th>
					<th>Action</th>

				</tr>
			</thead>
			<!-- body to display the student details -->
			<tbody>
				<c:forEach items="${Students}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>
						<td><c:out value="${tempStudent.course}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/student/Updateform?studentId=${tempStudent.id}"
							class="btn btn-outline-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/student/delete?studentId=${tempStudent.id}"
							class="btn btn-outline-danger btn-sm">Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="text-right">
			<!-- Add a button -->
			<a href="/student/Addform"
				class="btn btn-outline-success btn-sm mb-3"
				style="text-align: center"> Add Student </a>
		</div>
	</div>
</body>
</html>



