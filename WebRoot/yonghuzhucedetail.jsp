<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta >
  <title>用户详细</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="applicable-device" content="pc,mobile" />

<script type="text/javascript" src="qtimages/js/jquery.data.js"></script>
    <link href="qtimages/css/style.css" rel="stylesheet">
    <link href="qtimages/css/banner.css" rel="stylesheet">
        <script src="qtimages/js/jquery.min.js"></script>
        <script src="qtimages/js/bootstrap.js"></script>
        <script src="qtimages/js/jquery.flexslider-min.js"></script>
        <script src="qtimages/js/main.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
 <%
  String id=request.getParameter("id");
%>
<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>

<div class="about-wrap border-b">
    <div class="container">
        <div class="row">
            <div class="col-md-12 title-all">
                <h2>用户详细</h2>
            </div>
            <div class="about-cont col-md-12">
               
			 <table width="80%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='17%' height=44>用户名：</td>
     <td width='53%'>${yonghuzhuce.yonghuming}</td>
<td width="30%"  rowspan=10 align=center><a href=${yonghuzhuce.touxiang} target=_blank><img src=${yonghuzhuce.touxiang} width=228 height=215 border=0></a></td>
   </tr><tr>
<td width='17%' height=44>密码：</td>
<td width='53%'>${yonghuzhuce.mima}</td>
</tr><tr>
<td width='17%' height=44>姓名：</td>
<td width='53%'>${yonghuzhuce.xingming}</td>
</tr><tr>
<td width='17%' height=44>性别：</td>
<td width='53%'>${yonghuzhuce.xingbie}</td>
</tr><tr>
<td width='17%' height=44>出生年月：</td>
<td width='53%'>${yonghuzhuce.chushengnianyue}</td>
</tr><tr>
<td width='17%' height=44>QQ：</td>
<td width='53%'>${yonghuzhuce.QQ}</td>
</tr><tr>
<td width='17%' height=44>邮箱：</td>
<td width='53%'>${yonghuzhuce.youxiang}</td>
</tr><tr>
<td width='17%' height=44>手机：</td>
<td width='53%'>${yonghuzhuce.shouji}</td>
</tr><tr>
<td width='17%' height=44>身份证：</td>
<td width='53%'>${yonghuzhuce.shenfenzheng}</td>
</tr><tr>

<td width='17%' height=44>地址：</td>
<td width='53%'>${yonghuzhuce.dizhi}</td>
</tr><tr>

<td width='17%' height=100  >备注：</td>
<td colspan=2 height=100 >${yonghuzhuce.beizhu}</td>
</tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

					  
					  
            </div>
        </div>
    </div>
</div>

<jsp:include page="sidebufen.jsp"></jsp:include>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>