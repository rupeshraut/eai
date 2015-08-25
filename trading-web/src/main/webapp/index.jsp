<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table style="color: Grey; font-style: normal; font-size: small; text-decoration: none; font-family: Verdana; font-weight: normal;">
			<tr>
				<th>One</th>
				<th>Two</th>
			</tr>
			<c:if test="${not empty items}">
				<c:forEach items="${items}" var="_var">
					<tr style="background-color: Silver;">
						<td>One</td>
						<td>Two</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</body>
</html>