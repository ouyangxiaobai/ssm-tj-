<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>健康日志详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  健康日志详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${jiankangrizhi.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${jiankangrizhi.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${jiankangrizhi.xingbie}</td>     <td width='11%'>年龄：</td><td width='39%'>${jiankangrizhi.nianling}</td></tr><tr>     <td width='11%'>睡眠时长：</td><td width='39%'>${jiankangrizhi.shuimianshichang}</td>     <td width='11%'>饮酒量：</td><td width='39%'>${jiankangrizhi.yinjiuliang}</td></tr><tr>     <td width='11%'>吸烟量：</td><td width='39%'>${jiankangrizhi.xiyanliang}</td>     <td width='11%'>血压：</td><td width='39%'>${jiankangrizhi.xueya}</td></tr><tr>     <td width='11%'>体重：</td><td width='39%'>${jiankangrizhi.tizhong}</td>     <td width='11%'>运动量：</td><td width='39%'>${jiankangrizhi.yundongliang}</td></tr><tr>     <td width='11%'>饮食：</td><td width='39%'>${jiankangrizhi.yinshi}</td>     <td width='11%'>今日心情：</td><td width='39%'>${jiankangrizhi.jinrixinqing}</td></tr><tr>     <td width='11%'>今日热量：</td><td width='39%'>${jiankangrizhi.jinrireliang}</td>     <td width='11%'>日志分析：</td><td width='39%'>${jiankangrizhi.rizhifenxi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

