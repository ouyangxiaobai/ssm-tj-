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
		<TITLE>修改体检结果</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="tijianjieguo_add.jsp?id=<%=id%>";
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
			<form action="updateTijianjieguo.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改体检结果<input type="hidden" name="id" value="${tijianjieguo.id}" /></td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  readonly='readonly' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">项目名称：</td><td><input name='xiangmumingcheng' type='text' id='xiangmumingcheng' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">相关附件：</td><td><input name='xiangguanfujian' type='text' id='xiangguanfujian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('xiangguanfujian')"/></div></td></tr>		<tr ><td width="200"><tr><td>结果：</td><td><select name='jieguo' id='jieguo' class="form-control"><option value="正常">正常</option><option value="异常">异常</option></select></td></tr>		<tr ><td width="200">结果分析：</td><td><textarea name='jieguofenxi' cols='50' rows='5' id='jieguofenxi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${tijianjieguo.gonghao}';</script>	<script language="javascript">document.form1.xingming.value='${tijianjieguo.xingming}';</script>	<script language="javascript">document.form1.xiangmumingcheng.value='${tijianjieguo.xiangmumingcheng}';</script>	<script language="javascript">document.form1.xiangguanfujian.value='${tijianjieguo.xiangguanfujian}';</script>	<script language="javascript">document.form1.jieguo.value='${tijianjieguo.jieguo}';</script>	<script language="javascript">document.form1.jieguofenxi.value='${tijianjieguo.jieguofenxi}';</script>	
					 </table>
			</form>
   </body>
</html>






