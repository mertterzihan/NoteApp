<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags"%>

<%@ page session="false" %>
<html>
<head>
	<title>List of Notes</title>
</head>
<body>
<table>
	<tr>
		<td>
			<form name="New" action="new" method="get">
				<input type="submit" value="New">
			</form>
		</td>
		<td>
			<form name="Delete" action="delete" method="get">
				<input type="submit" value="Delete a Note">
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<h2>
				The list of the notes that you have taken:  
			</h2>
		</td>
	</tr>
</table>
<table border="1">
	  <tr>
	  	<th>Note</th>
	  	<th>Date</th>
	  	<th>Priority</th>
	  </tr>
      <c:forEach var="instance" items="${instances}">
        <tr>
          <td>${instance.note}</td>
          <td>${instance.date}</td>
          <td>${instance.priority}</td>
        </tr>
     </c:forEach>
 </table>
</body>
</html>
	