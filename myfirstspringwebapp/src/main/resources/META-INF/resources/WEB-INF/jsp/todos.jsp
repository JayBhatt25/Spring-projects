<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Todos</title>
	</head>
	
	<body>
		<div class="container">
			<div>Welcome ${name }</div>
			<div>Your todos are </div>
			<table class="table">
			<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th>Actions</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done }</td>
						<td>
							<div>
								<a href="update-todo?id=${todo.id }"  class="btn btn-primary">Update</a>
								<a href="delete-todo?id=${todo.id }"  class="btn btn-danger">Delete</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>