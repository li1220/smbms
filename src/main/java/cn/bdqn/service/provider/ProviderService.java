package cn.bdqn.service.provider;

import java.util.List;

import cn.bdqn.entity.Page;
import cn.bdqn.entity.Provider;

public interface ProviderService {
	
	public Page getPage(String pageNum,String name,String code);

	public Integer getCountPro(Provider provider);
	
	public Provider getOnePro(Provider provider);
	
	public boolean insertPro(Provider provider);
	
	public boolean delectPro(Provider provider);
	
	public List<Provider> getAllPro(Provider provider);
	
	public boolean updatePro(Provider provider);
	
}
