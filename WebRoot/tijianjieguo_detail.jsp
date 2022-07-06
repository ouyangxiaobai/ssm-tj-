<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>体检结果详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  体检结果详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${tijianjieguo.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${tijianjieguo.xingming}</td></tr><tr>     <td width='11%'>项目名称：</td><td width='39%'>${tijianjieguo.xiangmumingcheng}</td>     <td width='11%'>相关附件：</td><td width='39%'><a href="${tijianjieguo.xiangguanfujian}">点此下载</a></td></tr><tr>     <td width='11%'>结果：</td><td width='39%'>${tijianjieguo.jieguo}</td>     <td width='11%'>结果分析：</td><td width='39%'>${tijianjieguo.jieguofenxi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

