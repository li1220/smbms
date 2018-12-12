package cn.bdqn.service.user;

import cn.bdqn.entity.Page;
import cn.bdqn.entity.User;

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
