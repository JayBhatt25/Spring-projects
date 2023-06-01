<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Add Todo Page</title>
	</head>
	
	<body>
		<div class="container">
			<h1>Add Todo</h1>
			<pre>${errorMessage }</pre>
			<form method="POST">
				<div class="mb-3">
					<label for="description" class="form-label">Description</label>
					<input type="text" name="description" id="description" class="form-control" required="required" />
				</div>
					<button type="submit" class="btn btn-primary">Add</button>
			</form> 
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>