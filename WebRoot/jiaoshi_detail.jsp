﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>教师详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  教师详细:
  <br><br>
   
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${jiaoshi.gonghao}</td>
     <td width='11%'>密码：</td><td width='39%'>${jiaoshi.mima}</td></tr><tr>
     <td width='11%'>姓名：</td><td width='39%'>${jiaoshi.xingming}</td>
     <td width='11%'>性别：</td><td width='39%'>${jiaoshi.xingbie}</td></tr><tr>
     <td width='11%'>年龄：</td><td width='39%'>${jiaoshi.nianling}</td>
     <td width='11%'>身份证：</td><td width='39%'>${jiaoshi.shenfenzheng}</td></tr><tr>
     <td width='11%'>电话：</td><td width='39%'>${jiaoshi.dianhua}</td>
     <td width='11%'>职称：</td><td width='39%'>${jiaoshi.zhicheng}</td></tr><tr>
     <td width='11%'>备注：</td><td width='39%'>${jiaoshi.beizhu}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

