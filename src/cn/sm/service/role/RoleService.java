package cn.sm.service.role;

import java.util.List;

import cn.sm.entity.Role;

public interface RoleService {

	public List<Role> findAllRole(Role role);
	
	public boolean delectRole(Role role);
	
	public boolean updateRole(Role role);
	
	public boolean insertRole(Role role);
}
