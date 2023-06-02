<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div><h1>Your Todos</h1></div>
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

<%@ include file="common/footer.jspf" %>