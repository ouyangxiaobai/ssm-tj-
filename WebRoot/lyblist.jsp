﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta >
  <title>在线留言</title>
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

<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>

<div class="about-wrap border-b">
    <div class="container">
        <div class="row">
            <div class="col-md-12 title-all">
                <h2>在线留言</h2>
            </div>
            <div class="about-cont col-md-12">
               
			   
			  <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
						<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#1E8EF4" class="newsline">
                            <tr>
                              <td width="85" rowspan="4" align="center" valign="middle" bgcolor="#FFFFFF"><img width='70'height='70' src=img/${u.xingbie}.gif border=0> </td>
                              <td height="20" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp; &nbsp; 留言于:${u.addtime} &nbsp;</td>
                            </tr>
                            <tr>
                              <td height="78" align="left" valign="top" bgcolor="#FFFFFF">&nbsp;${u.neirong}</td>
                            </tr>
                            <tr>
                              <td align="left" valign="middle" bgcolor="#FFFFFF" style="height: 25px">&nbsp; &nbsp;昵称：${u.cheng} &nbsp; &nbsp;电话：${u.shouji}&nbsp;&nbsp;邮 箱:${u.youxiang} &nbsp; QQ:${u.QQ}&nbsp; &nbsp; </td>
                            </tr>
                            <tr>
                              <td align="left" valign="middle" bgcolor="#FFFFFF" style="height: 25px">&nbsp; &nbsp;管理员回复：${u.huifuneirong}</td>
                            </tr>
                          </table>
						    </c:forEach>
							
							<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="lybList.do?page=1" >首页</a>
             <a href="lybList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="lybList.do?page=${page.page+1 }">下一页</a>
			<a href="lybList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
					  
					  
					  
            </div>
        </div>
    </div>
</div>

<jsp:include page="sidebufen.jsp"></jsp:include>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
