package cn.bdqn.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.entity.Page;
import cn.bdqn.entity.Provider;
import cn.bdqn.service.provider.ProviderService;

@Controller
public class ProviderController {
	@Autowired	
	private ProviderService ps;
	
	@RequestMapping("/gongyingshang")
	public ModelAndView gongyingshang(HttpServletResponse response, HttpServletRequest request,HttpSession session)throws Exception{
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		String num=request.getParameter("pageNum");
		Page page=ps.getPage(num, name, code);
		session.setAttribute("page", page.getPageProciderList());
		session.setAttribute("page2", page);
		Provider p=new Provider();
		p.setProCode(code);
		p.setProName(name);
		session.setAttribute("count",ps.getCountPro(p));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gys.jsp");
		return mv;	
	}
	
	@RequestMapping("/gys_view/{id}")
	public ModelAndView gys_view(HttpServletResponse response, HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		Provider pro=new Provider();
		pro.setProCode(id);
		session.setAttribute("pro", ps.getOnePro(pro));
		mv.setViewName("../gys_view.jsp");
		return mv;
	}
	
	
	@RequestMapping("/gys_add")
	public ModelAndView gys_add(HttpServletResponse response, HttpServletRequest request,HttpSession session)throws Exception{
		response.setCharacterEncoding("utf-8");
		ModelAndView mv=new ModelAndView();
		String code=request.getParameter("proCode");
		String name=request.getParameter("proName");
		String contact=request.getParameter("proContact");
		String phone=request.getParameter("proPhone");
		String address=request.getParameter("proAddress");
		String fax=request.getParameter("proFax");
		String desc=request.getParameter("proDesc");
		Long uid=(Long)session.getAttribute("uid");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate=sdf.parse(sdf.format(new Date()));
		Provider pro=new Provider();
		pro.setProCode(code);
		pro.setProName(name);
		pro.setProContact(contact);
		pro.setProPhone(phone);
		pro.setProAddress(address);
		pro.setProFax(fax);
		pro.setProDesc(desc);
		pro.setCreatedBy(uid);
		pro.setCreationDate(nowDate);
		if (ps.insertPro(pro)) {
			session.setAttribute("msg", "添加成功");
		}else {
			session.setAttribute("mag", "添加失败");
		}
		mv.setViewName("gongyingshang");
		return mv;
	}
	
	@RequestMapping("/gys_show/{id}")
	public ModelAndView gys_show(HttpServletResponse response, HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		Provider pro=new Provider();
		pro.setProCode(id);
		session.setAttribute("pro", ps.getOnePro(pro));
		mv.setViewName("../gys_show.jsp");
		return mv;
	}
	
	
	@RequestMapping("/gys_update")
	public ModelAndView gys_update(HttpServletResponse response, HttpServletRequest request,HttpSession session)throws Exception{
		response.setCharacterEncoding("utf-8");
		ModelAndView mv=new ModelAndView();
		String code=request.getParameter("proCode");
		String name=request.getParameter("proName");
		String contact=request.getParameter("proContact");
		String phone=request.getParameter("proPhone");
		String fax=request.getParameter("proFax");
		String desc=request.getParameter("proDesc");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate=sdf.parse(sdf.format(new Date()));
		Long uid=(Long) session.getAttribute("uid");
		Provider pro=new Provider();
		pro.setProCode(code);
		pro.setProName(name);
		pro.setProContact(contact);
		pro.setProPhone(phone);
		pro.setProFax(fax);
		pro.setProDesc(desc);
		pro.setModifyBy(uid);
		pro.setModifyDate(nowDate);
		if (ps.updatePro(pro)) {
			session.setAttribute("msg", "修改成功");
		}else {
			session.setAttribute("mag", "修改失败");
		}
		mv.setViewName("gongyingshang");
		return mv;
	}
	
	
	@RequestMapping("/gys_delect/{id}")
	public ModelAndView delectPro(HttpServletResponse response, HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		Provider pro=new Provider();
		pro.setProCode(id);
		if (ps.delectPro(pro)) {
			session.setAttribute("msg", "删除成功 ");
		}else {
			session.setAttribute("msg", "删除失败");
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("../gongyingshang");
		return mv;
	}
	
}
