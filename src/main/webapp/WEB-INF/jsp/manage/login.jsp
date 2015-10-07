<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css?v=201509231"/>
<title>后台登录</title>
<style type="text/css">
body .button{font-size:20px;font-weight:none;}
#login{text-align:center;font-size:14px;color:#333;margin:100px auto;}
#login span{margin:0 5px;}
#username,#password{width:120px;}
#submit{padding:6px 20px;font-size:14px;}
.input{padding:4px;width:120px;height:20px;outline:none;font-weight:bold;font-size:14px;}
</style>
<style>
#main{background:none;background-size:100%;min-height:640px;}
#login{background:#fff;width:382px;padding:30px;border-radius:3px;border:1px solid #f1f1f1;
  -webkit-transform: scale(0.5);
  -ms-transform: scale(0.5);
  transform: scale(0.5);
  transition: all 200ms cubic-bezier(0.24, 0.22, 0.015, 1.56), opacity 100ms linear;
  opacity: 0;
  pointer-events: auto;
}
.show #login{-webkit-transform:scale(1);-ms-transform:scale(1);transform:scale(1);opacity:1;}
#login:before{content:'';position:absolute;z-index:-1;border:1px dashed #1D9D74;top:5px;bottom:5px;left:5px;right:5px;-moz-box-shadow:0 0 0 1px #fff;-webkit-box-shadow:0 0 0 1px #fff;box-shadow:0 0 0 1px #fff}
h1{font-size:18px;text-align:center;color:#1D9D74;margin:0 0 30px 0;position:relative}
h1:after,h1:before{background-color:#1D9D74;content:"";height:1px;position:absolute;top:10px;width:100px}
h1:after{background-image:-webkit-gradient(linear, left top, right top, from(#1D9D74), to(#fff));right:0}
h1:before{background-image:-webkit-gradient(linear, right top, left top, from(#1D9D74), to(#fff));left:0}
fieldset{border:0;padding:0;margin:0}
#inputs input{font-weight:bold;background:#fff url(${pageContext.request.contextPath}/resources/images/manage/login-sprite.png) no-repeat;padding:10px 15px 10px 30px;margin:0 0 10px 0;width:140px;border:1px solid #ccc;border-radius:5px;}
#username{background-position:5px -8px !important}
#password{background-position:5px -58px !important}
#inputs input:focus{background-color:#fff;border-color:#1b926c;outline:none}
#submit{float:left}
#actions{margin:25px 0 0 0;}
#actions a{float:right;line-height:35px;margin-left:10px;font-size:12px;font-weight:normal;}
</style>
</head>
<body>
<div class="breadcrumb">
	<span class="crust"><a href="${pageContext.request.contextPath}/" class="crumb">首页</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="${pageContext.request.contextPath}/manage" class="crumb">后台首页</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="" class="crumb">后台登录</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
<form id="login" method="post" onsubmit="return validate();">
    <h1>欢迎登录</h1>
    <fieldset id="inputs">
        <input id="username" type="text" name="username" maxlength="20" placeholder="账号" autofocus required value=""/>   
        <input id="password" type="password" name="password" maxlength="20" placeholder="密码" required value=""/>
    </fieldset>
    <fieldset id="actions">
		<input type="submit" id="submit" class="button button-green" value="登录"/>
		<a href="#">忘记密码?</a><a href="#">注册</a>
    </fieldset>
</form>
<c:if test="${sessionScope.result != null}">
   	<c:out value="${sessionScope.result}"/>
   	<c:remove var="result" scope="session"/>
</c:if>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#username').focus();
	$('#main').addClass('show');
});
//提交校验
function validate() {
	if ($('#username').val()=='') {
		$('#username').focus();
		return false;
	}
	if ($('#password').val()=='') {
		$('#password').focus();
		return false;
	}
	$('#main').removeClass('show');
	return true;
}
</script>
</body>
</html>