<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>ssm后台管理系统 -- 登录</title>
<jsp:include page="/resources/inc/head.jsp" flush="true"/>
<style type="text/css">
#loginForm{width:290px;margin:0 auto;}
#loginForm div{margin-top:14px;}
.content{width:100%;height:177px;*height:173px;overflow:hidden;padding:5px;}
.shadow{position:absolute;width:90%;height:90%;background:#fff;z-index:9999;}
</style>
</head>
<body>
<div class="shadow"></div>
<div id="loginWindow" style="width:450px;height:360px;padding:5px 5px 0;background:#fff;overflow:hidden;">
	<div id="logo" style="border:1px solid #8DB2E3;text-align:center;">
		<img src="${pageContext.request.contextPath}/resources/images/manage/logo.png"/>
	</div>
	<div id="tabs" plain="true" style="margin:5px auto;">
		<div class="content" iconCls="icon-login" title="管理登录" fit="true" closable="false">
			<form id="loginForm" method="post">
				<div>
					<label for="username">帐　　号：</label>
					<input id="username" class="easyui-textbox" type="text" name="username" validType="length[4,20]" invalidMessage="必须为4~20个字符！" maxlength="20" style="width:220px;height:26px;"/>
				</div>
				<div>
					<label for="username">密　　码：</label>
					<input id="password" class="easyui-textbox" type="password" name="password" validType="length[4,20]" invalidMessage="必须为4~20个字符！" maxlength="20" style="width:220px;height:26px;"/>
				</div>
				<div>
					<label for="randCode">验证数字：</label>
					<img id="randimg" class="easyui-tooltip" src="http://www.xinbaby.com/randCode" title="看不清?换一个!" onclick="this.src='http://www.xinbaby.com/randCode?'+Math.random();" align="absmiddle" width="80px"/>
					<input id="randCode" class="easyui-textbox" type="text" name="randCode" validType="length[4,4]" invalidMessage="请输入验证码！" maxlength="4" style="width:60px;height:26px;"/>
					<label for="remember">
						<input id="remember" type="checkbox" checked="checked"/>记住密码
					</label>
				</div>
				<div>
					<input class="easyui-linkbutton" data-options="iconCls:'icon-ok'" type="submit" style="padding:5px 0px;width:100%;background:#fafafa;" vlaue="登 录"/>
				</div>
			</form>
		</div>
		<div class="content" iconCls="icon-phone" title="联系方式" fit="true" closable="true">
			<p><b>联 系 人：张恕征</b></p>
			<p><b>电子邮箱：469741414@qq.com</b></p>
			<p><b>个人博客：<a class="easyui-tooltip" href="http://www.zhangshuzheng.cn/" title="张恕征的博客" target="_blank">http://www.zhangshuzheng.cn/</a></b></p>
		</div>
		<div class="content" iconCls="icon-about" title="关于我们" fit="true" closable="true">
			<p>Copyright &copy; 2015 ZhangShuzheng All Rights Reserved.</p>
		</div>
	</div>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script type="text/javascript">
$(document).ready(function(){
	//初始化登录窗口
	$('#loginWindow').window({
		title:'ssm后台管理系统',
		iconCls:'icon-logo',
		draggable:true,
		resizable:false,
		collapsible:true,
		minimizable:false,
		maximizable:false,
		closable:false
	});
	//选项卡
	$('#tabs').tabs({
		tools:[{
			title:'返回首页',
			iconCls:'icon-home',
			handler:function() {
				location.href = '${pageContext.request.contextPath}/user';
			}
		}]
	});
	$('#loginForm').form({
		url:'${pageContext.request.contextPath}/manage/login?backurl=${param.backurl}',
		onSubmit:function() {
			if ($('#username').val() == '') {
				$.messager.show({
					title:'登录失败',
					msg:'请输入登录账号！',
					timeout:3000,
					showType:'slide'
				});
				return false;
			}
			if ($('#password').val() == '') {
				$.messager.show({
					title:'登录失败',
					msg:'请输入登录密码！',
					timeout:3000,
					showType:'slide'
				});
				return false;
			}
			return $(this).form('validate');
		},
		success:function(result) {
			var result = result.replace(/[ ]/g,'').replace(/[\r\n]/g,'');
			var json = eval('('+result+')');
			if(json.result == 'success') {
				if (json.info == '') {
					location.reload(true);
					return;
				}
				location.href='${pageContext.request.contextPath}' + json.data;
				return;
			}
			$.messager.show({
				title:'登录失败',
				msg:json.data,
				timeout:3000,
				showType:'slide'
			});
			$('#randimg').attr('src','http://www.xinbaby.com/randCode?'+Math.random());
			$('#randCode').val('').get(0).focus();
		}
	});
	//隐藏遮罩层
	$('.shadow').fadeOut(600);
});
</script>
</body>
</html>