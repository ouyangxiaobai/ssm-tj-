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

import com.entity.Jiaoshi;
import com.server.JiaoshiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiaoshiController {
	@Resource
	private JiaoshiServer jiaoshiService;


   
	@RequestMapping("addJiaoshi.do")
	public String addJiaoshi(HttpServletRequest request,Jiaoshi jiaoshi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiaoshi.setAddtime(time.toString().substring(0, 19));
		jiaoshiService.add(jiaoshi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiaoshiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiaoshiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiaoshi.do")
	public String doUpdateJiaoshi(int id,ModelMap map,Jiaoshi jiaoshi){
		jiaoshi=jiaoshiService.getById(id);
		map.put("jiaoshi", jiaoshi);
		return "jiaoshi_updt";
	}
	
	@RequestMapping("doUpdateJiaoshi2.do")
	public String doUpdateJiaoshi2(ModelMap map,Jiaoshi jiaoshi,HttpServletRequest request){
		jiaoshi=jiaoshiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("jiaoshi", jiaoshi);
		return "jiaoshi_updt2";
	}
	
@RequestMapping("updateJiaoshi2.do")
	public String updateJiaoshi2(int id,ModelMap map,Jiaoshi jiaoshi){
		jiaoshiService.update(jiaoshi);
		return "redirect:doUpdateJiaoshi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("jiaoshiDetail.do")
	public String jiaoshiDetail(int id,ModelMap map,Jiaoshi jiaoshi){
		jiaoshi=jiaoshiService.getById(id);
		map.put("jiaoshi", jiaoshi);
		return "jiaoshi_detail";
	}
//	前台详细
	@RequestMapping("jsDetail.do")
	public String jsDetail(int id,ModelMap map,Jiaoshi jiaoshi){
		jiaoshi=jiaoshiService.getById(id);
		map.put("jiaoshi", jiaoshi);
		return "jiaoshidetail";
	}
//	
	@RequestMapping("updateJiaoshi.do")
	public String updateJiaoshi(int id,ModelMap map,Jiaoshi jiaoshi,HttpServletRequest request,HttpSession session){
		jiaoshiService.update(jiaoshi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiaoshiList.do";
	}

//	分页查询
	@RequestMapping("jiaoshiList.do")
	public String jiaoshiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_list";
	}
	
	@RequestMapping("jiaoshi_yanben1.do")
	public String jiaoshi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_yanben1";
	}
	@RequestMapping("jiaoshi_yanben2.do")
	public String jiaoshi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_yanben2";
	}
	@RequestMapping("jiaoshi_yanben3.do")
	public String jiaoshi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_yanben3";
	}
	@RequestMapping("jiaoshi_yanben4.do")
	public String jiaoshi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_yanben4";
	}
	@RequestMapping("jiaoshi_yanben5.do")
	public String jiaoshi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshi_yanben5";
	}
	
	
	
	@RequestMapping("jsList.do")
	public String jsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshilist";
	}
	@RequestMapping("jsListtp.do")
	public String jsListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshi jiaoshi, String gonghao, String mima, String xingming, String xingbie, String nianling, String shenfenzheng, String dianhua, String zhicheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshi> list=jiaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshilisttp";
	}
	
	@RequestMapping("deleteJiaoshi.do")
	public String deleteJiaoshi(int id,HttpServletRequest request){
		jiaoshiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiaoshiList.do";
	}
	
	@RequestMapping("quchongJiaoshi.do")
	public void quchongJiaoshi(Jiaoshi jiaoshi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", jiaoshi.getGonghao());
		   System.out.println("gonghao==="+jiaoshi.getGonghao());
		   System.out.println("gonghao222==="+jiaoshiService.quchongJiaoshi(map));
		   JSONObject obj=new JSONObject();
		   if(jiaoshiService.quchongJiaoshi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
