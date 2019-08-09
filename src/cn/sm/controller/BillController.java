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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sm.entity.Bill;
import cn.sm.entity.Page;
import cn.sm.entity.Provider;
import cn.sm.service.bill.BillService;
import cn.sm.service.provider.ProviderService;
@Controller
public class BillController {
	@Autowired
	private BillService bs;
	@Autowired
	private ProviderService ps;
	
	@RequestMapping("/dingdan")
	public ModelAndView bill_dingdan(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		Provider provider=new Provider();
		session.setAttribute("plist", ps.getAllPro(provider));
		String name=request.getParameter("name");
		String num=request.getParameter("pageNum");
		Integer gys=0;
		if (request.getParameter("gys")!=null) {
			gys=Integer.valueOf(request.getParameter("gys"));
			if (gys==-1) {
				gys=0;
			}
		}
		Integer pay=null;
		if (request.getParameter("pay")!=null) {
			pay=Integer.valueOf(request.getParameter("pay"));
			if (pay==-1) {
				pay=null;
			}
		}
		Page page=bs.getPage(num, name, gys, pay);
		session.setAttribute("page", page.getPageBillList());
		session.setAttribute("page2", page);
		Bill bill=new Bill();
		bill.setProductName(name);
		bill.setIsPayment(pay);
		bill.setProviderId(gys);
		session.setAttribute("count",bs.getCountBill(bill));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bill.jsp");
		return mv;
	}
	@RequestMapping("/bill_delect/{id}")
	public ModelAndView bill_delect(HttpSession session,HttpServletRequest request,HttpServletResponse response,@PathVariable String id)throws Exception{
		Bill bill=new Bill();
		bill.setBillCode(id);	
		if (bs.delectBill(bill)) {
			session.setAttribute("msg","删除成功");
		}else {
			session.setAttribute("msg", "删除失败");
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("../dingdan");
	return mv;
	}
	
	@RequestMapping("/bill_add")
	public ModelAndView bill_add(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Provider provider=new Provider();
		List<Provider> plist=ps.getAllPro(provider);
		session.setAttribute("plist", plist);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bill_add.jsp");
		return mv;
	}
	
	@RequestMapping("/bill_show/{id}")
	public ModelAndView bill_show(HttpSession session,HttpServletRequest request,HttpServletResponse response,@PathVariable String id)throws Exception{
		Bill bill=new Bill();
		bill.setBillCode(id);
		Provider provider=new Provider();
		List<Provider> plist=ps.getAllPro(provider);
		session.setAttribute("plist", plist);
		session.setAttribute("bill", bs.getOneBill(bill));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("../bill_show.jsp");
		return mv;
	}
	@RequestMapping("/bill_insert")
	public ModelAndView bill_insert(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		String name=request.getParameter("nname");
		String unit=request.getParameter("unit");
		String count=request.getParameter("count");
		String price=request.getParameter("price");
		String providerId=request.getParameter("providerId");
		String pay=request.getParameter("pay");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate=sdf.parse(sdf.format(new Date()));
		Long uid=(Long) session.getAttribute("uid");
		Bill bill=new Bill();
		bill.setBillCode(code);
		bill.setProductName(name);
		bill.setProductUnit(unit);
		bill.setProductCount(Double.valueOf(count));
		bill.setTotalPrice(Double.valueOf(price));
		bill.setProviderId(Integer.valueOf(providerId));
		bill.setCreatedBy(uid);
		bill.setIsPayment(Integer.valueOf(pay));
		bill.setCreationDate(nowDate);
		ModelAndView mv=new ModelAndView();
		if (bs.insertBill(bill)) {
			session.setAttribute("msg", "新增成功");
		}else {
			session.setAttribute("msg","新增失败");
		}
		mv.setViewName("dingdan");
		return mv;
	}
	
	@RequestMapping("/bill_view/{id}")
	public ModelAndView bill_view(HttpSession session,HttpServletRequest request,HttpServletResponse response,@PathVariable String id)throws Exception{
		Bill bill=new Bill();
		bill.setBillCode(id);
		session.setAttribute("bill", bs.getOneBill(bill));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("../bill_view.jsp");
		return mv;
	}
	
	@RequestMapping(value="/bill_gys",method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Provider> getProviderList(){
		List<Provider> providerList = null;
		try {
			Provider provider=new Provider();
			providerList = ps.getAllPro(provider);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return providerList;
	}
	
}
