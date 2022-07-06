<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="nav-wrap">
    <div class="navbar-top hidden-xs hidden-sm">
        <div class="container">
            <div class="row">
                <div class="col-md-7 col-sm-7 nav-ad">
                    <span class="visible-lg">欢迎来到- <b class="ht_company">高校体检管理系统</b> -网站!</span>
                </div>
                <div class="col-md-4 col-sm-5 nav-tel-top">
				 <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
                   <a href="userlog.jsp">登录</a> | <a href="jiaoshiadd.jsp">注册</a>
				  <%}else{ %>
	    <font color="#FFFFFF"> <%=request.getSession().getAttribute("username")%>,[ <%=request.getSession().getAttribute("cx")%>]&nbsp;</font> <a href="logout.jsp" onclick="return confirm('确定要退出？')" >退出</a><a href="main.jsp" >后台</a>
	    <%} %>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar">
            <div class="navbar_m">
                <div class="container navbar-header clearfix">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#smbj-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
						</button>
                    <div class="navbar-brand"><table width="100%" border="0">
  <tr>
    <td > <img src="qtimages/logo.jpg" width="94" height="87" class="ht_imgv ht_logoimg" />  </td>
    <td><div style="margin-top: 5pt; font-weight: bold; font-size: 19pt; filter: Glow(Color=#000000,Strength=2);
                  width: 100%; color: #996600; font-family: 宋体">
                  <div align="center" class="STYLE5">
                      高校体检管理系统</div>
              </div></td>
  </tr>
</table>
               </div>

                    <div class="tel fr">
                        <input placeholder="请输入搜索关键词" style="padding:0;line-height:25px;" /><button style="border:none;padding:2px 10px;background:#6ac0f0;color:#fff;margin-top:20px;line-height:25px;">搜索</button>
                    </div>
                </div>
                <div class="collapse navbar-collapse navbar-right L-nav" id="smbj-navbar">
                   	   <ul class='nav navbar-nav container'>
                        <li class='active'><a href='index.do'>网站首页</a></li>
						 <li ><a href='xwtzList.do?lb=健康新闻'>健康新闻</a></li>
						  <li><a href='xwtzList.do?lb=网站公告'>网站公告</a></li>
						   <li><a href='dx_detail.jsp?lb=关于我们'>关于我们</a></li>
						   <li><a href='lyb.jsp'>在线留言</a></li>
						   <li><a href='lybList.do'>查看留言</a></li>
					
                        <li class='L-nav-li'><a href='login.jsp'>后台管理</a><ol style='background:#6ac0f0;text-align:center;position:absolute;top:52px;z-index:99;width:100%;display:none;'></ol></li>
                    </ul>

                </div>
            </div>
    </nav>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('.L-nav-li').hover(function(){
			var ol_index = $(this).index() - 1;
			$('.L-nav-li>ol').eq(ol_index).toggle();
			console.log(ol_index);
		})
	});
	$(window).scroll(function(){
		var as = $(window).scrollTop();
		console.log(as);
		if(as>136){
			$('.L-nav').css({
				'position':'fixed',
				'z-index':'999',
				'top':'0',
				'width':'100%',
			})
		}else{
			$('.L-nav').css({
				'position':'relative',
				'':'',
				'':'',
				'':'',
			})
		}
	})
</script>