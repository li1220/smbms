package cn.sm.service.user;

import cn.sm.entity.Page;
import cn.sm.entity.User;

public interface UserService {

	public User findUser(User user);
	
	public boolean updateUser(User user);
	
	public Page getPage(String pageNum,String yhm,Integer cole);
	
	public Integer getCount(User user);
	
	public boolean delectUser(User user);
	
	public User getUser(User user);
	
	public boolean updateUser2(User user);
	
	public boolean insertUser(User user);
}
