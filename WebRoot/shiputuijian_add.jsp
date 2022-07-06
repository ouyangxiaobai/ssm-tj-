<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加食谱推荐</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
  id=request.getParameter("id");
   %>

<script language="javascript">

function gows()
{
	document.location.href="shiputuijian_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addShiputuijian.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加食谱推荐</td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  readonly='readonly' /></td></tr><script language="javascript">document.form1.gonghao.value='<%=connDbBean.readzd("gerenxinxi","gonghao","id",request.getParameter("id"))%>';document.form1.gonghao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("gerenxinxi","xingming","id",request.getParameter("id"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">周一：</td><td><textarea name='zhouyi' cols='50' rows='5' id='zhouyi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周二：</td><td><textarea name='zhouer' cols='50' rows='5' id='zhouer' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周三：</td><td><textarea name='zhousan' cols='50' rows='5' id='zhousan' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周四：</td><td><textarea name='zhousi' cols='50' rows='5' id='zhousi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周五：</td><td><textarea name='zhouwu' cols='50' rows='5' id='zhouwu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周六：</td><td><textarea name='zhouliu' cols='50' rows='5' id='zhouliu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">周日：</td><td><textarea name='zhouri' cols='50' rows='5' id='zhouri' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr 0><td width="200">饮食建议：</td><td><textarea name='yinshijianyi' cols='50' rows='5' id='yinshijianyi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>