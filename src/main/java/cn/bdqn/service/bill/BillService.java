package cn.bdqn.service.bill;

import cn.bdqn.entity.Bill;
import cn.bdqn.entity.Page;

public interface BillService {
	
	public Page getPage(String pageNum,String name,Integer pid,Integer pay );
	
	public Integer getCountBill(Bill bill);
	
	public boolean insertBill(Bill bill);
	
	public boolean delectBill(Bill bill);
	
	public Bill getOneBill(Bill bill);

}
