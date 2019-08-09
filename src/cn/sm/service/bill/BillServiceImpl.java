package cn.sm.service.bill;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm.dao.bill.BillMapper;
import cn.sm.entity.Bill;
import cn.sm.entity.Page;
@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillMapper bm;

	@Override
	public Page getPage(String pageNum, String name, Integer pid, Integer pay) {
		Integer num=1;
		if(pageNum!=null&&!pageNum.equals("".trim())){
			num=Integer.valueOf(pageNum);
		}
		Bill bi=new Bill();
		Integer zongTiao=bm.getAllCount(bi);
		Page page=new Page(zongTiao, num);
		Integer zongYe=page.getZongYe();
		if (num>zongYe) {
			num=zongYe;
		}
		if (num<1) {
			num=1;
		}
		page=new Page(zongTiao,num);
		page.setPageNum(num);
		bi.setPage(page);
		bi.setProductName(name);
		bi.setIsPayment(pay);
		bi.setProviderId(pid);
		List<Bill> blist=bm.findAll(bi);
		List<Bill> list=new ArrayList<Bill>();
		for (Bill b : blist) {
			bi=new Bill();
			bi.setId(b.getId());
			bi.setBillCode(b.getBillCode());
			bi.setProductName(b.getProductName());
			bi.setProductDesc(b.getProductDesc());
			bi.setProductUnit(b.getProductUnit());
			bi.setProductCount(b.getProductCount());
			bi.setTotalPrice(b.getTotalPrice());
			if (b.getIsPayment()==1) {
				bi.setPay("未付款");
			}else if (b.getIsPayment()==2) {
				bi.setPay("已付款");
			}
			bi.setCreatedBy(b.getCreatedBy());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date1=null;
			String date2=null;
			if (b.getCreationDate()!=null) {
				 date1=sdf.format(b.getCreationDate());
			}
			if (b.getModifyDate()!=null) {
				 date2=sdf.format(b.getModifyDate());
			}
			bi.setCreationTime(date1);
			bi.setModifyTime(date2);
			bi.setModifyBy(b.getModifyBy());
			bi.setProName(b.getProName());
			list.add(bi);
		}
		page.setPageBillList(list);
		return page;
			
	}

	@Override
	public Integer getCountBill(Bill bill) {
		return bm.getAllCount(bill);
	}

	@Override
	public boolean delectBill(Bill bill) {
		if (bm.delectBill(bill)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean insertBill(Bill bill) {
		if (bm.insertBill(bill)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Bill getOneBill(Bill bill) {
		return bm.getOneBill(bill);
	}
		
}
