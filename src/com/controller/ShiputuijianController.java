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

import com.entity.Shiputuijian;
import com.server.ShiputuijianServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShiputuijianController {
	@Resource
	private ShiputuijianServer shiputuijianService;


   
	@RequestMapping("addShiputuijian.do")
	public String addShiputuijian(HttpServletRequest request,Shiputuijian shiputuijian,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shiputuijian.setAddtime(time.toString().substring(0, 19));
		shiputuijianService.add(shiputuijian);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shiputuijianList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shiputuijianList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShiputuijian.do")
	public String doUpdateShiputuijian(int id,ModelMap map,Shiputuijian shiputuijian){
		shiputuijian=shiputuijianService.getById(id);
		map.put("shiputuijian", shiputuijian);
		return "shiputuijian_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shiputuijianDetail.do")
	public String shiputuijianDetail(int id,ModelMap map,Shiputuijian shiputuijian){
		shiputuijian=shiputuijianService.getById(id);
		map.put("shiputuijian", shiputuijian);
		return "shiputuijian_detail";
	}
//	前台详细
	@RequestMapping("sptjDetail.do")
	public String sptjDetail(int id,ModelMap map,Shiputuijian shiputuijian){
		shiputuijian=shiputuijianService.getById(id);
		map.put("shiputuijian", shiputuijian);
		return "shiputuijiandetail";
	}
//	
	@RequestMapping("updateShiputuijian.do")
	public String updateShiputuijian(int id,ModelMap map,Shiputuijian shiputuijian,HttpServletRequest request,HttpSession session){
		shiputuijianService.update(shiputuijian);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shiputuijianList.do";
	}

//	分页查询
	@RequestMapping("shiputuijianList.do")
	public String shiputuijianList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_list";
	}
	
	@RequestMapping("shiputuijian_yanben1.do")
	public String shiputuijian_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_yanben1";
	}
	@RequestMapping("shiputuijian_yanben2.do")
	public String shiputuijian_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_yanben2";
	}
	@RequestMapping("shiputuijian_yanben3.do")
	public String shiputuijian_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_yanben3";
	}
	@RequestMapping("shiputuijian_yanben4.do")
	public String shiputuijian_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_yanben4";
	}
	@RequestMapping("shiputuijian_yanben5.do")
	public String shiputuijian_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_yanben5";
	}
	
	@RequestMapping("shiputuijianList2.do")
	public String shiputuijianList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijian_list2";
	}	
	
	@RequestMapping("sptjList.do")
	public String sptjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijianlist";
	}
	@RequestMapping("sptjListtp.do")
	public String sptjListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shiputuijian shiputuijian, String gonghao, String xingming, String zhouyi, String zhouer, String zhousan, String zhousi, String zhouwu, String zhouliu, String zhouri, String yinshijianyi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(zhouyi==null||zhouyi.equals("")){pmap.put("zhouyi", null);}else{pmap.put("zhouyi", zhouyi);}		if(zhouer==null||zhouer.equals("")){pmap.put("zhouer", null);}else{pmap.put("zhouer", zhouer);}		if(zhousan==null||zhousan.equals("")){pmap.put("zhousan", null);}else{pmap.put("zhousan", zhousan);}		if(zhousi==null||zhousi.equals("")){pmap.put("zhousi", null);}else{pmap.put("zhousi", zhousi);}		if(zhouwu==null||zhouwu.equals("")){pmap.put("zhouwu", null);}else{pmap.put("zhouwu", zhouwu);}		if(zhouliu==null||zhouliu.equals("")){pmap.put("zhouliu", null);}else{pmap.put("zhouliu", zhouliu);}		if(zhouri==null||zhouri.equals("")){pmap.put("zhouri", null);}else{pmap.put("zhouri", zhouri);}		if(yinshijianyi==null||yinshijianyi.equals("")){pmap.put("yinshijianyi", null);}else{pmap.put("yinshijianyi", yinshijianyi);}		
		int total=shiputuijianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shiputuijian> list=shiputuijianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shiputuijianlisttp";
	}
	
	@RequestMapping("deleteShiputuijian.do")
	public String deleteShiputuijian(int id,HttpServletRequest request){
		shiputuijianService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shiputuijianList.do";
	}
	
	
}
