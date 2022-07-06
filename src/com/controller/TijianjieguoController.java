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

import com.entity.Tijianjieguo;
import com.server.TijianjieguoServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TijianjieguoController {
	@Resource
	private TijianjieguoServer tijianjieguoService;


   
	@RequestMapping("addTijianjieguo.do")
	public String addTijianjieguo(HttpServletRequest request,Tijianjieguo tijianjieguo,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tijianjieguo.setAddtime(time.toString().substring(0, 19));
		tijianjieguoService.add(tijianjieguo);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tijianjieguoList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tijianjieguoList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTijianjieguo.do")
	public String doUpdateTijianjieguo(int id,ModelMap map,Tijianjieguo tijianjieguo){
		tijianjieguo=tijianjieguoService.getById(id);
		map.put("tijianjieguo", tijianjieguo);
		return "tijianjieguo_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("tijianjieguoDetail.do")
	public String tijianjieguoDetail(int id,ModelMap map,Tijianjieguo tijianjieguo){
		tijianjieguo=tijianjieguoService.getById(id);
		map.put("tijianjieguo", tijianjieguo);
		return "tijianjieguo_detail";
	}
//	前台详细
	@RequestMapping("tjjgDetail.do")
	public String tjjgDetail(int id,ModelMap map,Tijianjieguo tijianjieguo){
		tijianjieguo=tijianjieguoService.getById(id);
		map.put("tijianjieguo", tijianjieguo);
		return "tijianjieguodetail";
	}
//	
	@RequestMapping("updateTijianjieguo.do")
	public String updateTijianjieguo(int id,ModelMap map,Tijianjieguo tijianjieguo,HttpServletRequest request,HttpSession session){
		tijianjieguoService.update(tijianjieguo);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tijianjieguoList.do";
	}

//	分页查询
	@RequestMapping("tijianjieguoList.do")
	public String tijianjieguoList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_list";
	}
	
	@RequestMapping("tijianjieguo_yanben1.do")
	public String tijianjieguo_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_yanben1";
	}
	@RequestMapping("tijianjieguo_yanben2.do")
	public String tijianjieguo_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_yanben2";
	}
	@RequestMapping("tijianjieguo_yanben3.do")
	public String tijianjieguo_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_yanben3";
	}
	@RequestMapping("tijianjieguo_yanben4.do")
	public String tijianjieguo_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_yanben4";
	}
	@RequestMapping("tijianjieguo_yanben5.do")
	public String tijianjieguo_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_yanben5";
	}
	
	@RequestMapping("tijianjieguoList2.do")
	public String tijianjieguoList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguo_list2";
	}	
	
	@RequestMapping("tjjgList.do")
	public String tjjgList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguolist";
	}
	@RequestMapping("tjjgListtp.do")
	public String tjjgListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijianjieguo tijianjieguo, String gonghao, String xingming, String xiangmumingcheng, String xiangguanfujian, String jieguo, String jieguofenxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xiangmumingcheng==null||xiangmumingcheng.equals("")){pmap.put("xiangmumingcheng", null);}else{pmap.put("xiangmumingcheng", xiangmumingcheng);}		if(xiangguanfujian==null||xiangguanfujian.equals("")){pmap.put("xiangguanfujian", null);}else{pmap.put("xiangguanfujian", xiangguanfujian);}		if(jieguo==null||jieguo.equals("")){pmap.put("jieguo", null);}else{pmap.put("jieguo", jieguo);}		if(jieguofenxi==null||jieguofenxi.equals("")){pmap.put("jieguofenxi", null);}else{pmap.put("jieguofenxi", jieguofenxi);}		
		int total=tijianjieguoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijianjieguo> list=tijianjieguoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijianjieguolisttp";
	}
	
	@RequestMapping("deleteTijianjieguo.do")
	public String deleteTijianjieguo(int id,HttpServletRequest request){
		tijianjieguoService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tijianjieguoList.do";
	}
	
	
}
