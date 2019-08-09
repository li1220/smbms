package cn.sm.controller;

import java.io.PrintWriter;
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

import cn.sm.entity.Page;
import cn.sm.entity.Role;
import cn.sm.entity.User;
import cn.sm.service.role.RoleService;
import cn.sm.service.user.UserService;
import cn.sm.util.DecriptUtil;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	DecriptUtil dp=new DecriptUtil();
	
	@RequestMapping("/login")
	public ModelAndView Login(HttpServletRequest request,HttpSession session) throws Exception{
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		User user=new User();
		user.setUserCode(name);
		user.setUserPassword(dp.MD5(pass));
		ModelAndView mv=new ModelAndView();
		if (us.findUser(user)!=null) {
			session.setAttribute("id", name);
			session.setAttribute("uid", us.findUser(user).getId());
			session.setAttribute("name", us.findUser(user).getUserName());
			mv.setViewName("dingdan");
		}else {
			mv.setViewName("login.jsp");
		}
		return mv;
		
	}
	@RequestMapping("/loginout")
	public ModelAndView loginout(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mv=new ModelAndView();
			mv.addObject("name", "");
			mv.setViewName("login.jsp");
		return mv;
		
	}
	
	@RequestMapping("/xgxx")
	public ModelAndView update(HttpServletRequest request,HttpSession session) throws Exception{
		request.setCharacterEncoding("utf-8");
		String pass=request.getParameter("xinmima");
		User user=new User();
		String id=(String) session.getAttribute("id");
		user.setUserCode(id);
		user.setUserPassword(dp.MD5(pass));
		ModelAndView mv=new ModelAndView();
		if (us.updateUser(user)) {
			mv.setViewName("loginout");
		}else {
			mv.setViewName("xiugaimima.jsp");
		}
		return mv;
		
	}
	@RequestMapping("/panduan")
	public void panduan(HttpServletRequest request, HttpServletResponse response,HttpSession session)throws Exception {
		String name=(String) session.getAttribute("id");
		String pass=request.getParameter("pass");
		boolean panduan=false;
		User user=new User();
		user.setUserCode(name);
		user.setUserPassword(dp.MD5(pass));
		if (us.findUser(user)!=null) {
			panduan=true;
		}
		response.setContentType("text/html,charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(panduan);
		out.flush();
		out.close();
		
	}
	@RequestMapping("/yhgl")
	public ModelAndView guanli(HttpServletResponse response, HttpServletRequest request,HttpSession session)throws Exception{
		Role r=new Role();
		response.setCharacterEncoding("utf-8");
		String yhm=request.getParameter("yhm");
		String juese=request.getParameter("juese");
		Integer jue=0;
		if (juese!=null) {
			jue=Integer.valueOf(juese);
			if (jue==-1) {
				jue=0;
			}
		}
		String num=request.getParameter("pageNum");
		List<Role> rlist=rs.findAllRole(r);
		session.setAttribute("rlist", rlist);
		Page page=us.getPage(num,yhm,jue);
		session.setAttribute("page", page.getPageUserList());
		session.setAttribute("page2", page);
		User user=new User();
		user.setUserName(yhm);
		user.setUserRole(jue);
		session.setAttribute("count", us.getCount(user));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("yhgl.jsp");
		return mv;
	}
	@RequestMapping("/user_delect/{id}")
	public ModelAndView delect(HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setUserCode(id);
		if (us.delectUser(user)) {
			session.setAttribute("msg", "删除成功");
		}else {
			session.setAttribute("msg", "删除失败");
		}
		mv.setViewName("../yhgl");
		return mv;
	}
	@RequestMapping("/user_view/{id}")
	public ModelAndView View(HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setUserCode(id);
		user=us.getUser(user);
		session.setAttribute("user", user);
		mv.setViewName("../user_view.jsp");
		return mv;
	}
	
	@RequestMapping("/user_show/{id}")
	public ModelAndView Show(HttpServletRequest request,HttpSession session,@PathVariable String id)throws Exception{
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setUserCode(id);
		user=us.getUser(user);
		session.setAttribute("user", user);
		mv.setViewName("../user_show.jsp");
		return mv;
	}
	
	@RequestMapping("/user_update/{id}")
	public ModelAndView Insert(HttpServletRequest request,HttpServletResponse response ,HttpSession session,@PathVariable String id )throws Exception{
		ModelAndView mv=new ModelAndView();
		response.setCharacterEncoding("utf-8");	
		String name=request.getParameter("userName");
		String gender=request.getParameter("gender");
		Integer sex=null;
		if (gender!=null) {
			sex=Integer.valueOf(gender);
		}
		String riqi=request.getParameter("riqi");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		if (riqi!=null) {
			birthday=sdf.parse(riqi);
		}
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String userRole=request.getParameter("userRole");
		Integer userRolee=null;
		if (userRole!=null) {
			userRolee=Integer.valueOf(userRole);
		}
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate=sdf.parse(sdf.format(new Date()));
		User user=new User();
		Long uid=(Long) session.getAttribute("uid");
		user.setUserCode(id);
		user.setUserName(name);
		user.setGender(sex);
		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setAddress(address);
		user.setUserRole(userRolee);
		user.setModifyBy(uid);
		user.setModifyDate(nowDate);
		if (us.updateUser2(user)) {
			session.setAttribute("msg", "修改成功");
		}else {
			session.setAttribute("msg", "修改失败");
		}
		mv.setViewName("../yhgl");
		return mv;
	}
	@RequestMapping("/user_add")
	public ModelAndView add(HttpSession session)throws Exception {
		ModelAndView mv=new ModelAndView();
		Role r=new Role();
		List<Role> rlist=rs.findAllRole(r);
		session.setAttribute("rlist", rlist);
		mv.setViewName("user_add.jsp");
		return mv;
	}
	@RequestMapping("/user_insert")
	public ModelAndView insert(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mv=new ModelAndView();
		response.setCharacterEncoding("utf-8");	
		String id=request.getParameter("userCode");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		Integer sex=null;
		if (gender!=null) {
			sex=Integer.valueOf(gender);
		}
		String riqi=request.getParameter("riqi");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		if (riqi!=null) {
			birthday=sdf.parse(riqi);
		}
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String userRole=request.getParameter("userRole");
		Integer userRolee=null;
		if (userRole!=null) {
			userRolee=Integer.valueOf(userRole);
		}
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate=sdf.parse(sdf.format(new Date()));
		User user=new User();
		Long uid=(Long) session.getAttribute("uid");
		user.setUserCode(id);
		user.setUserName(name);
		user.setUserPassword(dp.MD5(password));
		user.setGender(sex);
		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setAddress(address);
		user.setUserRole(userRolee);
		user.setCreatedBy(uid);
		user.setCreationDate(nowDate);
		if (us.insertUser(user)) {
			session.setAttribute("msg", "新增成功");
		}else {
			session.setAttribute("msg", "新增失败");
		}
		mv.setViewName("yhgl");
		return mv;
		
	}
	
	
	
}
