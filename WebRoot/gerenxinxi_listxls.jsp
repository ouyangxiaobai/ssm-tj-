<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gerenxinxihsgb" scope="page" class="com.bean.GerenxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gerenxinxi.xls");
%>
<html>
  <head>
    <title>个人信息</title>
  </head>

  <body >
 <%
			String sql="select * from gerenxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>年龄</td>    <td align='center' bgcolor='#ebf0f7'>身高</td>    <td align='center' bgcolor='#ebf0f7'>体重</td>    <td align='center' bgcolor='#ebf0f7'>血压</td>            
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gerenxinxihsgb.getAllGerenxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.nianling}</td>    <td>${u.shengao}</td>    <td>${u.tizhong}</td>    <td>${u.xueya}</td>            
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

