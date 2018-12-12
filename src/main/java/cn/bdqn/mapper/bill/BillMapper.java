package cn.bdqn.mapper.bill;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bdqn.entity.Bill;
@Component
public interface BillMapper {
	
	public Integer getAllCount(Bill bill);
	
	public List<Bill> findAll(Bill bill);
	
	public Integer insertBill(Bill bill);
	
	public Bill getOneBill(Bill bill);
	
	public Integer delectBill(Bill bill);
}
