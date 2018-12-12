package cn.bdqn.service.provider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.provider.ProviderMapper;
import cn.bdqn.entity.Page;
import cn.bdqn.entity.Provider;
@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderMapper pm;
	@Override
	public Page getPage(String pageNum, String name, String code) {
		Integer num=1;
		if(pageNum!=null&&!pageNum.equals("".trim())){
			num=Integer.valueOf(pageNum);
		}
		Provider p=new Provider();
		Integer zongTiao=pm.getAllCount(p);
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
		p.setPage(page);
		p.setProCode(code);
		p.setProName(name);
		List<Provider> plist=pm.findAll(p);
		List<Provider> pplist=new ArrayList<Provider>();
		for (Provider pp : plist) {
			Provider pro=new Provider();
			pro.setId(pp.getId());
			pro.setProCode(pp.getProCode());
			pro.setProName(pp.getProName());
			pro.setProDesc(pp.getProDesc());
			pro.setProContact(pp.getProContact());
			pro.setProPhone(pp.getProPhone());
			pro.setProAddress(pp.getProAddress());
			pro.setProFax(pp.getProFax());
			pro.setCreatedBy(pp.getCreatedBy());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date1=null;
			String date2=null;
			if (pp.getCreationDate()!=null) {
				 date1=sdf.format(pp.getCreationDate());
			}
			if (pp.getModifyDate()!=null) {
				 date2=sdf.format(pp.getModifyDate());
			}
			pro.setCreationTime(date1);
			pro.setModifyTime(date2);
			pro.setModifyBy(pp.getModifyBy());
			pplist.add(pro);
		}
		page.setPageProciderList(pplist);
		return page;
	}
	@Override
	public Integer getCountPro(Provider provider) {
		return pm.getAllCount(provider);
	}
	@Override
	public Provider getOnePro(Provider provider) {
		return pm.getOnePro(provider);
	}
	@Override
	public boolean insertPro(Provider provider) {
		if (pm.insertPro(provider)>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delectPro(Provider provider) {
		if (pm.delectPro(provider)>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Provider> getAllPro(Provider provider) {
		return pm.findAll2(provider);
	}
	@Override
	public boolean updatePro(Provider provider) {
		if (pm.updatePro(provider)>0) {
			return true;
		}else {
			return false;
		}
		
	}

}
