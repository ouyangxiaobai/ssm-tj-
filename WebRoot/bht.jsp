 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<div class="flexslider">
    <ul class="slides">
 <%
			int xxbhti=0;
			String sqlbht="select id, shouyetupian from xinwentongzhi where leibie='变幻图'  order by id desc limit 0,5";
			ResultSet RS_resultbht=connDbBean.executeQuery(sqlbht);
while(RS_resultbht.next())
{
	xxbhti++;
		%>
		<li>
                    <img class="ht_banner1 ht_imgv" src="<%=RS_resultbht.getString("shouyetupian")%>"  />
                </li>
<%
		}
		%>

    </ul>
</div>