<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
 <%
  String lb=request.getParameter("lb");
  //String lb=new String(request.getParameter("lb").getBytes("8859_1"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta >
  <title><%=lb%></title>
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
                <h2><%=lb%></h2>
            </div>
            <div class="about-cont col-md-12">
               
			   
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FA8A89" class="newsline" style="border-collapse:collapse">
                          
                          <tr>
                            <td height="110" align="left"><%=connDbBean.readzd("dx","content","leibie",lb)%></td>
                          </tr>
                          <tr>
                            <td height="33" align="right"><input type="button" name="Submit5" value="返回" onClick="javascript:history.back();" ></td>
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