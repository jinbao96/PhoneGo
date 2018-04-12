<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${catelist}" var="category">
					<dl>
						<dt><a href="index.jsp?category_id=1">${category.category_name}</a></dt>
						<c:forEach items="${category.childs}" var="child">
							<dd><a href="index.jsp?child_id=电脑">${child}</a></dd>
						</c:forEach>
					</dl>
				</c:forEach>
</body>
</html>