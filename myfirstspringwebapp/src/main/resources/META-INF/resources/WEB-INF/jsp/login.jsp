
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Login</h1>
		<pre>${errorMessage }</pre>
		<form method="POST">
			<div class="mb-3">
				<label for="login-username" class="form-label">Name</label>
				<input type="text" name="name" id="login-username" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="login-password" class="form-label">password</label>
				<input type="password" name="password" class="form-control" id="login-password" />
			</div>	  
				<button type="submit" class="btn btn-primary">Submit</button>
		</form> 
	</div>
	<%@ include file="common/footer.jspf" %>	