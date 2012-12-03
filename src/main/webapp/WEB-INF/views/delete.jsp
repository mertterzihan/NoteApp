<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Delete a Note</title>
</head>
<body>
	<h2>Delete Note</h2>
	<form id="deleteForm" action="delete">
		<fieldset>
			<table cellspacing="0" border="1">
				<tr>
					<th>Selection</th>
					<th>Note</th>
					<th>Date</th>
					<th>Priority</th>
				</tr>
				<c:forEach var="instance" items="${instances}">
					<tr>
						<td><input type="radio" name="note" value="${instance.id}"></td>
						<td>${instance.note}</td>
						<td>${instance.date}</td>
						<td>${instance.priority}</td>
					</tr>
				</c:forEach>

				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<script>
		$("#deleteForm").submit(
				function(event) {

					event.preventDefault();
					var $form = $(this), 
					note = $form.find("input[name=note]").val(),
					url = $form.attr( 'action' );
					$.post(url, {
						note : note
					},
					function redirect(){
						window.location.replace("home");
					});
				}); 
	</script>
</body>
</html>