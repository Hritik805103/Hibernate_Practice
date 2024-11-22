<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/cdn.jsp"%>

</head>
<body class="bg-light">
	<%@include file="component/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Register Page</p>
						<c:if test="${not empty msg}">
							<p class="text-center text-danger fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="register" method="post">
							<div class="mb-3">

								<label>Enter Full Name</label> <input type="text" name="name"
									class="form-control"> <label>Enter Email</label> <input
									type="email" name="email" class="form-control"> <label>Password</label>
								<input type="password" name="password" class="form-control">

								<label>About</label> <input type="text" name="about"
									class="form-control">
							</div>

							<button class="btn btn-success col-md-12">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>