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
		<TITLE>修改健康日志</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="jiankangrizhi_add.jsp?id=<%=id%>";
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
			<form action="updateJiankangrizhi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改健康日志<input type="hidden" name="id" value="${jiankangrizhi.id}" /></td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.gonghao.value='<%=connDbBean.readzd("jiaoshi","gonghao","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.gonghao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("jiaoshi","xingming","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingbie.value='<%=connDbBean.readzd("jiaoshi","xingbie","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingbie.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.nianling.value='<%=connDbBean.readzd("jiaoshi","nianling","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.nianling.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">睡眠时长：</td><td><input name='shuimianshichang' type='text' id='shuimianshichang' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">饮酒量：</td><td><input name='yinjiuliang' type='text' id='yinjiuliang' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">吸烟量：</td><td><input name='xiyanliang' type='text' id='xiyanliang' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">血压：</td><td><input name='xueya' type='text' id='xueya' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">体重：</td><td><input name='tizhong' type='text' id='tizhong' value='' onblur='' class="form-control" /></td></tr>
		<tr 0><td width="200">运动量：</td><td><textarea name='yundongliang' cols='50' rows='5' id='yundongliang' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr 1><td width="200">饮食：</td><td><textarea name='yinshi' cols='50' rows='5' id='yinshi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr 2><td width="200">今日心情：</td><td><textarea name='jinrixinqing' cols='50' rows='5' id='jinrixinqing' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<!--<tr 3><td width="200"><tr><td>今日热量：</td><td><select name='jinrireliang' id='jinrireliang' class="form-control"><option value="偏低">偏低</option><option value="正常">正常</option><option value="超出">超出</option></select></td></tr>
		<tr 4><td width="200">日志分析：</td><td><textarea name='rizhifenxi' cols='50' rows='5' id='rizhifenxi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		-->
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${jiankangrizhi.gonghao}';</script>
	<script language="javascript">document.form1.xingming.value='${jiankangrizhi.xingming}';</script>
	<script language="javascript">document.form1.xingbie.value='${jiankangrizhi.xingbie}';</script>
	<script language="javascript">document.form1.nianling.value='${jiankangrizhi.nianling}';</script>
	<script language="javascript">document.form1.shuimianshichang.value='${jiankangrizhi.shuimianshichang}';</script>
	<script language="javascript">document.form1.yinjiuliang.value='${jiankangrizhi.yinjiuliang}';</script>
	<script language="javascript">document.form1.xiyanliang.value='${jiankangrizhi.xiyanliang}';</script>
	<script language="javascript">document.form1.xueya.value='${jiankangrizhi.xueya}';</script>
	<script language="javascript">document.form1.tizhong.value='${jiankangrizhi.tizhong}';</script>
	<script language="javascript">document.form1.yundongliang.value='${jiankangrizhi.yundongliang}';</script>
	<script language="javascript">document.form1.yinshi.value='${jiankangrizhi.yinshi}';</script>
	<script language="javascript">document.form1.jinrixinqing.value='${jiankangrizhi.jinrixinqing}';</script>
	<script language="javascript">document.form1.jinrireliang.value='${jiankangrizhi.jinrireliang}';</script>
	<script language="javascript">document.form1.rizhifenxi.value='${jiankangrizhi.rizhifenxi}';</script>
	
					 </table>
			</form>
   </body>
</html>






