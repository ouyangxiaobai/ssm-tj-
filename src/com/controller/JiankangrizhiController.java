package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Jiankangrizhi;
import com.server.JiankangrizhiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiankangrizhiController {
	@Resource
	private JiankangrizhiServer jiankangrizhiService;


   
	@RequestMapping("addJiankangrizhi.do")
	public String addJiankangrizhi(HttpServletRequest request,Jiankangrizhi jiankangrizhi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiankangrizhi.setAddtime(time.toString().substring(0, 19));
		jiankangrizhiService.add(jiankangrizhi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiankangrizhiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiankangrizhiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiankangrizhi.do")
	public String doUpdateJiankangrizhi(int id,ModelMap map,Jiankangrizhi jiankangrizhi){
		jiankangrizhi=jiankangrizhiService.getById(id);
		map.put("jiankangrizhi", jiankangrizhi);
		return "jiankangrizhi_updt";
	}
	
	
	
	@RequestMapping("doUpdateJiankangrizhilb.do")
	public String doUpdateJiankangrizhilb(int id,ModelMap map,Jiankangrizhi jiankangrizhi){
		jiankangrizhi=jiankangrizhiService.getById(id);
		map.put("jiankangrizhi", jiankangrizhi);
		return "jiankangrizhi_updtlb";
	}
	
@RequestMapping("updateJiankangrizhilb.do")
	public String updateJiankangrizhilb(int id,ModelMap map,Jiankangrizhi jiankangrizhi){
		jiankangrizhiService.updatelb(jiankangrizhi);
		return "redirect:jiankangrizhiList.do";
	}
	
//	后台详细
	@RequestMapping("jiankangrizhiDetail.do")
	public String jiankangrizhiDetail(int id,ModelMap map,Jiankangrizhi jiankangrizhi){
		jiankangrizhi=jiankangrizhiService.getById(id);
		map.put("jiankangrizhi", jiankangrizhi);
		return "jiankangrizhi_detail";
	}
//	前台详细
	@RequestMapping("jkrzDetail.do")
	public String jkrzDetail(int id,ModelMap map,Jiankangrizhi jiankangrizhi){
		jiankangrizhi=jiankangrizhiService.getById(id);
		map.put("jiankangrizhi", jiankangrizhi);
		return "jiankangrizhidetail";
	}
//	
	@RequestMapping("updateJiankangrizhi.do")
	public String updateJiankangrizhi(int id,ModelMap map,Jiankangrizhi jiankangrizhi,HttpServletRequest request,HttpSession session){
		jiankangrizhiService.update(jiankangrizhi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiankangrizhiList.do";
	}

//	分页查询
	@RequestMapping("jiankangrizhiList.do")
	public String jiankangrizhiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_list";
	}
	
	@RequestMapping("jiankangrizhi_yanben1.do")
	public String jiankangrizhi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_yanben1";
	}
	@RequestMapping("jiankangrizhi_yanben2.do")
	public String jiankangrizhi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_yanben2";
	}
	@RequestMapping("jiankangrizhi_yanben3.do")
	public String jiankangrizhi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_yanben3";
	}
	@RequestMapping("jiankangrizhi_yanben4.do")
	public String jiankangrizhi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_yanben4";
	}
	@RequestMapping("jiankangrizhi_yanben5.do")
	public String jiankangrizhi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_yanben5";
	}
	
	@RequestMapping("jiankangrizhiList2.do")
	public String jiankangrizhiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhi_list2";
	}	
	
	@RequestMapping("jkrzList.do")
	public String jkrzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhilist";
	}
	@RequestMapping("jkrzListtp.do")
	public String jkrzListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangrizhi jiankangrizhi, String gonghao, String xingming, String xingbie, String nianling, String shuimianshichang, String yinjiuliang, String xiyanliang, String xueya, String tizhong, String yundongliang, String yinshi, String jinrixinqing, String jinrireliang, String rizhifenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shuimianshichang==null||shuimianshichang.equals("")){pmap.put("shuimianshichang", null);}else{pmap.put("shuimianshichang", shuimianshichang);}		if(yinjiuliang==null||yinjiuliang.equals("")){pmap.put("yinjiuliang", null);}else{pmap.put("yinjiuliang", yinjiuliang);}		if(xiyanliang==null||xiyanliang.equals("")){pmap.put("xiyanliang", null);}else{pmap.put("xiyanliang", xiyanliang);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(yundongliang==null||yundongliang.equals("")){pmap.put("yundongliang", null);}else{pmap.put("yundongliang", yundongliang);}		if(yinshi==null||yinshi.equals("")){pmap.put("yinshi", null);}else{pmap.put("yinshi", yinshi);}		if(jinrixinqing==null||jinrixinqing.equals("")){pmap.put("jinrixinqing", null);}else{pmap.put("jinrixinqing", jinrixinqing);}		if(jinrireliang==null||jinrireliang.equals("")){pmap.put("jinrireliang", null);}else{pmap.put("jinrireliang", jinrireliang);}		if(rizhifenxi==null||rizhifenxi.equals("")){pmap.put("rizhifenxi", null);}else{pmap.put("rizhifenxi", rizhifenxi);}		
		int total=jiankangrizhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangrizhi> list=jiankangrizhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangrizhilisttp";
	}
	
	@RequestMapping("deleteJiankangrizhi.do")
	public String deleteJiankangrizhi(int id,HttpServletRequest request){
		jiankangrizhiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiankangrizhiList.do";
	}
	
	
}
