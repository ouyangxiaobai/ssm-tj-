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

import com.entity.Jibingyucepinggu;
import com.server.JibingyucepingguServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JibingyucepingguController {
	@Resource
	private JibingyucepingguServer jibingyucepingguService;


   
	@RequestMapping("addJibingyucepinggu.do")
	public String addJibingyucepinggu(HttpServletRequest request,Jibingyucepinggu jibingyucepinggu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jibingyucepinggu.setAddtime(time.toString().substring(0, 19));
		jibingyucepingguService.add(jibingyucepinggu);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jibingyucepingguList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jibingyucepingguList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJibingyucepinggu.do")
	public String doUpdateJibingyucepinggu(int id,ModelMap map,Jibingyucepinggu jibingyucepinggu){
		jibingyucepinggu=jibingyucepingguService.getById(id);
		map.put("jibingyucepinggu", jibingyucepinggu);
		return "jibingyucepinggu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jibingyucepingguDetail.do")
	public String jibingyucepingguDetail(int id,ModelMap map,Jibingyucepinggu jibingyucepinggu){
		jibingyucepinggu=jibingyucepingguService.getById(id);
		map.put("jibingyucepinggu", jibingyucepinggu);
		return "jibingyucepinggu_detail";
	}
//	前台详细
	@RequestMapping("jbycpgDetail.do")
	public String jbycpgDetail(int id,ModelMap map,Jibingyucepinggu jibingyucepinggu){
		jibingyucepinggu=jibingyucepingguService.getById(id);
		map.put("jibingyucepinggu", jibingyucepinggu);
		return "jibingyucepinggudetail";
	}
//	
	@RequestMapping("updateJibingyucepinggu.do")
	public String updateJibingyucepinggu(int id,ModelMap map,Jibingyucepinggu jibingyucepinggu,HttpServletRequest request,HttpSession session){
		jibingyucepingguService.update(jibingyucepinggu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jibingyucepingguList.do";
	}

//	分页查询
	@RequestMapping("jibingyucepingguList.do")
	public String jibingyucepingguList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_list";
	}
	
	@RequestMapping("jibingyucepinggu_yanben1.do")
	public String jibingyucepinggu_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_yanben1";
	}
	@RequestMapping("jibingyucepinggu_yanben2.do")
	public String jibingyucepinggu_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_yanben2";
	}
	@RequestMapping("jibingyucepinggu_yanben3.do")
	public String jibingyucepinggu_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_yanben3";
	}
	@RequestMapping("jibingyucepinggu_yanben4.do")
	public String jibingyucepinggu_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_yanben4";
	}
	@RequestMapping("jibingyucepinggu_yanben5.do")
	public String jibingyucepinggu_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_yanben5";
	}
	
	@RequestMapping("jibingyucepingguList2.do")
	public String jibingyucepingguList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggu_list2";
	}	
	
	@RequestMapping("jbycpgList.do")
	public String jbycpgList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggulist";
	}
	@RequestMapping("jbycpgListtp.do")
	public String jbycpgListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jibingyucepinggu jibingyucepinggu, String gonghao, String xingming, String jibingmingcheng, String huanbinggailv, String zhuyishixiang, String yufangcuoshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jibingmingcheng==null||jibingmingcheng.equals("")){pmap.put("jibingmingcheng", null);}else{pmap.put("jibingmingcheng", jibingmingcheng);}		if(huanbinggailv==null||huanbinggailv.equals("")){pmap.put("huanbinggailv", null);}else{pmap.put("huanbinggailv", huanbinggailv);}		if(zhuyishixiang==null||zhuyishixiang.equals("")){pmap.put("zhuyishixiang", null);}else{pmap.put("zhuyishixiang", zhuyishixiang);}		if(yufangcuoshi==null||yufangcuoshi.equals("")){pmap.put("yufangcuoshi", null);}else{pmap.put("yufangcuoshi", yufangcuoshi);}		
		int total=jibingyucepingguService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jibingyucepinggu> list=jibingyucepingguService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jibingyucepinggulisttp";
	}
	
	@RequestMapping("deleteJibingyucepinggu.do")
	public String deleteJibingyucepinggu(int id,HttpServletRequest request){
		jibingyucepingguService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jibingyucepingguList.do";
	}
	
	
}
