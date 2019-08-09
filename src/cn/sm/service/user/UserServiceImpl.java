package cn.sm.service.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm.dao.user.UserMapper;
import cn.sm.entity.Page;
import cn.sm.entity.User;
import cn.sm.util.AgeUtil;
@Service
public class UserServiceImpl extends AgeUtil implements UserService  {
	@Autowired
	private UserMapper um;
	@Override
	public User findUser(User user) {
		return um.findUserByUserNameAndPassWord(user);
	}
	@Override
	public boolean updateUser(User user) {
		if (um.updateUser(user)>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Page getPage(String pageNum,String yhm,Integer cole) {
		Integer num=1;
		if(pageNum!=null&&!pageNum.equals("".trim())){
			num=Integer.valueOf(pageNum);
		}
		User user=new User();
		Integer zongTiao=um.getUserCount(user);
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
		user.setPage(page);
		user.setUserName(yhm);
		user.setUserRole(cole);
		List<User> elist=um.getUserPageList(user);
		List<User> ulist=new ArrayList<User>();
		for (User user2 : elist) {
			user=new User();
			user.setUserCode(user2.getUserCode());
			user.setUserName(user2.getUserName());
			if (user2.getGender()==1) {
				user.setSex("男");
			}else if (user2.getGender()==2) {
				user.setSex("女");
			}
			Integer age=null;
			try {
				 age=getAge(user2.getBirthday());
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setAge(age);
			user.setPhone(user2.getPhone());
			user.setRoleName(user2.getRoleName());
			ulist.add(user);
		}
		page.setPageUserList(ulist);
		return page;
	}
	@Override
	public Integer getCount(User user) {
		return um.getUserCount(user);
	}
	@Override
	public boolean delectUser(User user) {
		if (um.delectUser(user)>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public User getUser(User user) {
		user=um.getUser(user);
		if (user.getGender()==1) {
			user.setSex("男");
		}else if (user.getGender()==2) {
			user.setSex("女");
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		user.setRiqi(sdf.format(user.getBirthday()));
		return user;
	}
	@Override
	public boolean updateUser2(User user) {
		if (um.updateUser2(user)>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean insertUser(User user) {
		if (um.insertUser(user)>0) {
			return true;
		}else {
			return false;
		}
		
	}

}
