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

import com.entity.Gerenxinxi;
import com.server.GerenxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GerenxinxiController {
	@Resource
	private GerenxinxiServer gerenxinxiService;


   
	@RequestMapping("addGerenxinxi.do")
	public String addGerenxinxi(HttpServletRequest request,Gerenxinxi gerenxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gerenxinxi.setAddtime(time.toString().substring(0, 19));
		gerenxinxiService.add(gerenxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gerenxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gerenxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGerenxinxi.do")
	public String doUpdateGerenxinxi(int id,ModelMap map,Gerenxinxi gerenxinxi){
		gerenxinxi=gerenxinxiService.getById(id);
		map.put("gerenxinxi", gerenxinxi);
		return "gerenxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gerenxinxiDetail.do")
	public String gerenxinxiDetail(int id,ModelMap map,Gerenxinxi gerenxinxi){
		gerenxinxi=gerenxinxiService.getById(id);
		map.put("gerenxinxi", gerenxinxi);
		return "gerenxinxi_detail";
	}
//	前台详细
	@RequestMapping("grxxDetail.do")
	public String grxxDetail(int id,ModelMap map,Gerenxinxi gerenxinxi){
		gerenxinxi=gerenxinxiService.getById(id);
		map.put("gerenxinxi", gerenxinxi);
		return "gerenxinxidetail";
	}
//	
	@RequestMapping("updateGerenxinxi.do")
	public String updateGerenxinxi(int id,ModelMap map,Gerenxinxi gerenxinxi,HttpServletRequest request,HttpSession session){
		gerenxinxiService.update(gerenxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gerenxinxiList.do";
	}

//	分页查询
	@RequestMapping("gerenxinxiList.do")
	public String gerenxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_list";
	}
	
	@RequestMapping("gerenxinxi_yanben1.do")
	public String gerenxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_yanben1";
	}
	@RequestMapping("gerenxinxi_yanben2.do")
	public String gerenxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_yanben2";
	}
	@RequestMapping("gerenxinxi_yanben3.do")
	public String gerenxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_yanben3";
	}
	@RequestMapping("gerenxinxi_yanben4.do")
	public String gerenxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_yanben4";
	}
	@RequestMapping("gerenxinxi_yanben5.do")
	public String gerenxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_yanben5";
	}
	
	@RequestMapping("gerenxinxiList2.do")
	public String gerenxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxi_list2";
	}	
	
	@RequestMapping("grxxList.do")
	public String grxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxilist";
	}
	@RequestMapping("grxxListtp.do")
	public String grxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxinxi gerenxinxi, String gonghao, String xingming, String xingbie, String nianling, String shengao, String tizhong, String xueya, String shentiyichangqingkuang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shengao==null||shengao.equals("")){pmap.put("shengao", null);}else{pmap.put("shengao", shengao);}		if(tizhong==null||tizhong.equals("")){pmap.put("tizhong", null);}else{pmap.put("tizhong", tizhong);}		if(xueya==null||xueya.equals("")){pmap.put("xueya", null);}else{pmap.put("xueya", xueya);}		if(shentiyichangqingkuang==null||shentiyichangqingkuang.equals("")){pmap.put("shentiyichangqingkuang", null);}else{pmap.put("shentiyichangqingkuang", shentiyichangqingkuang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=gerenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxinxi> list=gerenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxinxilisttp";
	}
	
	@RequestMapping("deleteGerenxinxi.do")
	public String deleteGerenxinxi(int id,HttpServletRequest request){
		gerenxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gerenxinxiList.do";
	}
	
	
}
