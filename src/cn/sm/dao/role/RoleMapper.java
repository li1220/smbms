package cn.sm.dao.role;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.sm.entity.Role;

@Component
public interface RoleMapper {

	public List<Role> findAllRole(Role role);
	
	public Integer delectRole(Role role);
	
	public Integer updateRole(Role role);
	
	public Integer insertRole(Role role);
	
}
