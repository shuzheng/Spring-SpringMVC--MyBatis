<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>修改用户</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/list">返回</a>
<form method="post">
<p>帐号：<input type="text" name="username" value="${user.username}"/></p>
<p>密码：<input type="password" name="password" value="${user.password}"/></p>
<p>昵称：<input type="text" name="nickname" value="${user.nickname}"/></p>
<p>性别：<input type="text" name="sex" value="${user.sex}"/></p>
<p><input type="submit" value="保存"/></p>
</form>
</body>
</html>