package cn.sm.service.bill;

import cn.sm.entity.Bill;
import cn.sm.entity.Page;

public interface BillService {
	
	public Page getPage(String pageNum,String name,Integer pid,Integer pay );
	
	public Integer getCountBill(Bill bill);
	
	public boolean insertBill(Bill bill);
	
	public boolean delectBill(Bill bill);
	
	public Bill getOneBill(Bill bill);

}
