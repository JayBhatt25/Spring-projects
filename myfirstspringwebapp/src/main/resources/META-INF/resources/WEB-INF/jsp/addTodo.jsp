
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Add Todo</h1>
	<pre>${errorMessage }</pre>
	<form:form method="POST" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description" class="form-label">Description</form:label>
			<form:input type="text" path="description" id="description" class="form-control" required="required"  />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path="targetDate" class="form-label">Target Date</form:label>
			<form:input type="text" path="targetDate" id="description" class="form-control datepicker" required="required"  />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		
		<form:input type="text" path="id"  class="form-control" required="required" hidden="true"  />
		<form:input type="text" path="done" class="form-control" required="required" hidden="true" />
		<button type="submit" class="btn btn-primary">Add</button>
	</form:form> 
</div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
	$('.datepicker').datepicker({
	    format: 'mm-dd-yyyy'
	});
</script>