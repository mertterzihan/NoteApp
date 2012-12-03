<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Note</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<form id="newForm" action="new">
		<fieldset>
			<legend>New Note</legend>
			<table cellspacing="0">
				<tr>
					<th><label for="note">Note</label></th>
					<!-- <td><input size="100" id="note" name="note" /></td> -->
					<td><textarea rows="4" cols="40" name="note"></textarea></td>
				</tr>
				<tr>
					<th><label for="date">Date</label></th>
					<td><input id="datepicker" name="datepicker" /></td>
				</tr>
				<tr>
					<th><label for="priority">Priority</label></th>
					<td><select name="priority">
							<option value="Regular">Regular</option>
							<option value="High">High</option>
							<option value="Low">Low</option>
					</select></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<script>
		$("#newForm").submit(
				function(event) {

					event.preventDefault();
					var $form = $(this), 
					note = $form.find("textarea[name=note]").val(),
					datepicker = $form.find("input[name=datepicker]").val(),
					priority = $form.find("select[name=priority]").val(),
					url = $form.attr( 'action' );
					$.post(url, {
						note : note,
						datepicker : datepicker,
						priority : priority
					},
					function redirect(){
						window.location.replace("home");
					});
				}); 
	</script>
</body>
</html>