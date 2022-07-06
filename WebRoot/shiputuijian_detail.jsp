<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>食谱推荐详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  食谱推荐详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${shiputuijian.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${shiputuijian.xingming}</td></tr><tr>     <td width='11%'>周一：</td><td width='39%'>${shiputuijian.zhouyi}</td>     <td width='11%'>周二：</td><td width='39%'>${shiputuijian.zhouer}</td></tr><tr>     <td width='11%'>周三：</td><td width='39%'>${shiputuijian.zhousan}</td>     <td width='11%'>周四：</td><td width='39%'>${shiputuijian.zhousi}</td></tr><tr>     <td width='11%'>周五：</td><td width='39%'>${shiputuijian.zhouwu}</td>     <td width='11%'>周六：</td><td width='39%'>${shiputuijian.zhouliu}</td></tr><tr>     <td width='11%'>周日：</td><td width='39%'>${shiputuijian.zhouri}</td>     <td width='11%'>饮食建议：</td><td width='39%'>${shiputuijian.yinshijianyi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

