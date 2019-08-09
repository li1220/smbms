package cn.sm.service.provider;

import java.util.List;

import cn.sm.entity.Page;
import cn.sm.entity.Provider;

public interface ProviderService {
	
	public Page getPage(String pageNum,String name,String code);

	public Integer getCountPro(Provider provider);
	
	public Provider getOnePro(Provider provider);
	
	public boolean insertPro(Provider provider);
	
	public boolean delectPro(Provider provider);
	
	public List<Provider> getAllPro(Provider provider);
	
	public boolean updatePro(Provider provider);
	
}
