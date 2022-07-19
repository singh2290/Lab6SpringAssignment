<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Save Student</title>
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
		<p class="h4 mb-4">Student Details</p>

		<form action="/student/save" method="POST">


			<input type="hidden" name="id" value="${Student.id}" />

			<div class="form-group">
				<input type="text" name="firstName" value="${Student.firstName}"
					class="form-control mb-4 col-4" placeholder="FristName">
			</div>

			<div class="form-group">

				<input type="text" name="lastName" value="${Student.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">

			</div>

			<div class="form-group">

				<input type="text" name="course" value="${Student.course}"
					class="form-control mb-4 col-4" placeholder="Course">

			</div>
			<div class="form-inline">

				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">

			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/student/list">Back to Students List</a>

	</div>
</body>

</html>










