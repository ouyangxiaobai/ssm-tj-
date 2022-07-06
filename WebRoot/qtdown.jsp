<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<div class="footer-wrap">
    <div class="footer-border">
        <div class="container">

            <div class="col-md-12 footer-link hidden-sm hidden-xs">
                <span>友情链接：</span>
				 <%
			String sqlyqlj="select  * from youqinglianjie   order by id desc limit 0,5";
			ResultSet RS_resultyqlj=connDbBean.executeQuery(sqlyqlj);
while(RS_resultyqlj.next())
{
		%>
                <a href="<%=RS_resultyqlj.getString("wangzhi")%>" target="_blank" ><%=RS_resultyqlj.getString("wangzhanmingcheng")%></a><span>|</span>
  <%
								  }
								  %>
             

            </div>



        </div>

    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 footer-copy">
                <p>

                    <span class="ht_company">xxxxxx</span>&nbsp;&nbsp;
                    地址：<span class="ht_linkaddress">xxxxx</span>&nbsp;&nbsp;
                    联系人：<span class="ht_linkman">xxxx经理</span>&nbsp;&nbsp;
                    电话：<span class="ht_phone">xxxxxxxx</span><br/>
                    手机：<span class="ht_mobile">xxxxxxxxx</span>&nbsp;&nbsp;
                    微信：<span class="ht_wx">xxxxxxxxx</span>&nbsp;&nbsp;
                    QQ：<span class="ht_qq">xxxxxxxxx</span>&nbsp;&nbsp;
                    邮箱：<span class="ht_email">xxxxxxxxx@qq.com</span><br/>

                </p>
            </div>
        </div>
    </div>
</div>
