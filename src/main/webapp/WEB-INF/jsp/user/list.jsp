<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>用户列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/add">增</a>
<ul>
	<c:forEach var="user" items="${users}">
	<li>${user.id}、${user.username}|${user.password}|${user.nickname}|${user.sex}|${user.ctime} <a href="${pageContext.request.contextPath}/user/update/${user.id}">改</a> <a href="${pageContext.request.contextPath}/user/delete/${user.id}" onclick="return confirm('确认删除吗？');">删</a></li>
	</c:forEach>
</ul>
</body>
</html>