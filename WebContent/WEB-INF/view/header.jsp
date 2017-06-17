<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="divOuterFrame">
	<div class="divInnerFrame">欢迎使用SurveyDoor调查系统!</div>
</div>
<div class="divWhiteLine"></div>
<div class="divNavigatorOuterFrame">
	<div class="divNavigatorInnerFrame">
		<s:a action="login_index" >[首页]</s:a>&nbsp;
		<s:a action="survey-saveSurvey" >[新建调查]</s:a>&nbsp;
		<s:a action="survey-list" >[我的调查]</s:a>&nbsp;
		<s:a action="EngageSurveyAction_findAllAvailableSurveys" namespace="/">[参与调查]</s:a>&nbsp;
		<s:a action="reg_index" >[用户注册]</s:a>&nbsp;
		<s:a action="UserAuthorizeAction_findAllUsers" namespace="/">[用户授权管理]</s:a>&nbsp;
		<s:a action="RoleAction_findAllRoles" namespace="/">[角色管理]</s:a>&nbsp;
		<s:a action="RightAction_findAllRights" namespace="/">[权限管理]</s:a>&nbsp;
		<s:a action="LogAction_findNearestLogs" namespace="/">[日志管理]</s:a>&nbsp;
	</div>
</div>
<div class="divWhiteLine"></div>