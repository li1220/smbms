package cn.sm.dao.provider;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.sm.entity.Provider;
@Component
public interface ProviderMapper {
	
	public Integer getAllCount(Provider provider);
	
	public List<Provider> findAll(Provider provider);
	
	public Provider getOnePro(Provider provider);
	
	public Integer insertPro(Provider provider);
	
	public Integer delectPro(Provider provider);
	public List<Provider> findAll2(Provider provider);
	
	public Integer updatePro(Provider provider);
	
}
