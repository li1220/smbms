package cn.bdqn.mapper.user;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bdqn.entity.User;
@Component
public interface UserMapper {
	public User findUserByUserNameAndPassWord(User user);
	
	public Integer updateUser(User user);
	
	public Integer getUserCount(User user);
	
	public List<User> getUserPageList(User user);
	
	public Integer delectUser(User user);

	public User getUser(User user);
	
	public Integer insertUser(User user);
	
	public Integer updateUser2(User user);
}
