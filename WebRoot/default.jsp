<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta >
<title>高校体检管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="applicable-device" content="pc,mobile" />

<script type="text/javascript" src="qtimages/js/jquery.data.js"></script>
    <link href="qtimages/css/style.css" rel="stylesheet">
    <link href="qtimages/css/banner.css" rel="stylesheet">
        <script src="qtimages/js/jquery.min.js"></script>
        <script src="qtimages/js/bootstrap.js"></script>
        <script src="qtimages/js/jquery.flexslider-min.js"></script>
        <script src="qtimages/js/main.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>



<div class="about-wrap2 border-b">
    <div class="container">
        <div class="row">
            <div class="col-md-12 title-all">
                <h2>关于我们</h2>
            </div>
            <div class="about-cont col-md-12">
                <img src="qtimages/images/13.jpg" alt="关于我们" title="关于我们" class="fl about-img" />
                <div class="about-text ht_aboutus">
                    <p style="text-indent: 2em;">本公司坚持走:以质量求生存,以科技求发展,重合同守信用的道路,生产经营得到迅速发展。我们将以优质的产品和最完善的售后服务来真诚与各界朋友开展广泛的合作,共同创造一个美好的未来!公司的软、硬环境的设计和管理都应满足人性化的要求，让人性化的关怀触手可及!诚信为本，稳健经营。</p><p style="text-indent: 2em;">经营理念：</p><p style="text-indent: 2em;">我们的口号——服务至上争创一流诚信为本共铸繁荣</p><p style="text-indent: 2em;">我们的信念——不离不弃，永不言败，不骄不躁、勇往直前</p><p style="text-indent: 2em;">我们的企业风格——高效、勤奋、务实、创新</p><p style="text-indent: 2em;">我们的工作作风——信心、专心、恒心、爱心、细心、热心</p><p style="text-indent: 2em;">我们的素质修养——自觉、自律、自省、自悟</p>
                </div>
            </div>
        </div>
    </div>
</div>


   
 

<div class="news-wrap wrap-all">
    <div class="container">
        <div class="row">
            <div class="col-md-12 news-title title-all">
                <h2>健康新闻</h2>
            </div>
            <div class="col-md-12 news-content">
                <div class="row news-firstbox">
                    <div class="col-md-12">
                        <ul>
						 <%
				  	int xwi=0;
				  %>
				  <c:forEach items="${syxinwentongzhi1 }" var="a">
				  <%
				  	xwi++;
					if(xwi<=4)
					{
				  %>
                            <li class="news-li clearfix">
                                <div class="news-left fl">
                                    <a href="xwtzDetail.do?id=${a.id}">
                                        <img src="${a.shouyetupian}" />
                                    </a>
                                </div>
                                <div class="news-body fr">
                                    <h3><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 30)}</a></h3>
                                    <p class="text-ellipsis">${fn:substring(a.zhaiyao, 0, 50)}</p>
                                    <p>发布时间:${fn:substring(a.addtime, 0, 10)}</p>
                                </div>
                            </li>
						<%
					}
					%>
                   </c:forEach>

                           
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="sidebufen.jsp"></jsp:include>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>