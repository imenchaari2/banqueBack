<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajout de compte</h1>
	<form action="CompteController" method="POST">
		<table>
			<tr>
				<td>Solde</td>
				<td><input type="text" name="solde"></td>
			</tr>
			<tr>
				<td>Client</td>
				<td><input type="text" name="client"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="add"></td>
			</tr>
		</table>

	</form>
</body>
</html>