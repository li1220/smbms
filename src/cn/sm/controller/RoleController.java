package cn.sm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sm.entity.Role;
import cn.sm.service.role.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService rs;
	
	@RequestMapping("/juese")
	public ModelAndView findAll(HttpServletRequest request)throws Exception{
		ModelAndView mv=new ModelAndView();
		Role r=new Role();
		List<Role> rlist=rs.findAllRole(r);
		mv.addObject("rlist", rlist);
		mv.setViewName("role.jsp");
		return mv;
	} 
	
	@RequestMapping("/role_delect/{id}")
	public ModelAndView delectRole(HttpSession session,HttpServletRequest request,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		Role role=new Role();
		role.setRoleCode(id);
		if (rs.delectRole(role)) {
			session.setAttribute("msg", "删除成功");
		}else {
			session.setAttribute("msg", "删除失败");
		}
		mv.setViewName("../juese");
		return mv;
	}
	@RequestMapping("/role_select/{id}")
	public ModelAndView selectRole(HttpSession session,HttpServletRequest request,@PathVariable String id,HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		Role role=new Role();
		role.setRoleCode(id);
		List<Role> rlist=rs.findAllRole(role);
		for (Role role2 : rlist) {
			role=new Role();
			role.setRoleCode(role2.getRoleCode());
			role.setRoleName(role2.getRoleName());
			role.setCreatedBy(role2.getCreatedBy());
			role.setCreationDate(role2.getCreationDate());
			role.setModifyBy(role2.getModifyBy());
			role.setModifyDate(role2.getModifyDate());
			role.setId(role2.getId());
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("../role_show.jsp");
		session.setAttribute("list", role);
		return mv;
		}
		
		@RequestMapping("/role_update")
		public ModelAndView updateRole(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
			response.setCharacterEncoding("utf-8");
			String id=request.getParameter("roleCode");
			String name=request.getParameter("roleName");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowDate=sdf.parse(sdf.format(new Date()));
			Long uid=(Long) session.getAttribute("uid");
			Role role=new Role();
			role.setRoleCode(id);
			role.setRoleName(name);
			role.setModifyBy(uid);
			role.setModifyDate(nowDate);
			if (rs.updateRole(role)) {
				session.setAttribute("msg", "修改成功");
			}else {
				session.setAttribute("msg", "修改失败");
			}
			ModelAndView mv=new ModelAndView();
			mv.setViewName("juese");
			return mv;
		}
		@RequestMapping("/role_insert")
		public ModelAndView insertRole(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
			response.setCharacterEncoding("utf-8");
			String id=request.getParameter("roleCode");
			String name=request.getParameter("roleName");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowDate=sdf.parse(sdf.format(new Date()));
			Long uid=(Long) session.getAttribute("uid");
			Role role=new Role();
			role.setRoleCode(id);
			role.setRoleName(name);
			role.setCreatedBy(uid);
			role.setCreationDate(nowDate);
			if (rs.insertRole(role)) {
				session.setAttribute("msg", "新增成功");
			}else {
				session.setAttribute("mag", "新增失败");
			}
			ModelAndView mv=new ModelAndView();
			mv.setViewName("juese");
			return mv;
			
			
			
		}
	
}
