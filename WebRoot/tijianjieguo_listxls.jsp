<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="tijianjieguohsgb" scope="page" class="com.bean.TijianjieguoBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=tijianjieguo.xls");
%>
<html>
  <head>
    <title>�����</title>
  </head>

  <body >
 <%
			String sql="select * from tijianjieguo  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>��Ŀ����</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>��ظ���</td>    <td align='center' bgcolor='#ebf0f7'>���</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=tijianjieguohsgb.getAllTijianjieguo(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td>${u.xiangmumingcheng}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='${u.xiangguanfujian}' target='_blank'>����</a></td>    <td>${u.jieguo}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

