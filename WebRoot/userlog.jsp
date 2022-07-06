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
  <title>用户登陆</title>
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
                <h2>用户登陆</h2>
            </div>
            <div class="about-cont col-md-12">
			
			<table width="100%" border="0" bgcolor="#a6e2fe">
  <tr>
    <td width="35%" >  <img src="qtimages/qtlog.jpg" class="fl about-img" /> </td>
    <td width="65%"><jsp:include page="qtuserlog.jsp"></jsp:include></td>
  </tr>
</table>

            </div>
        </div>
    </div>
</div>

<jsp:include page="sidebufen.jsp"></jsp:include>
<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>