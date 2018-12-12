package cn.bdqn.mapper.role;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bdqn.entity.Role;

@Component
public interface RoleMapper {

	public List<Role> findAllRole(Role role);
	
	public Integer delectRole(Role role);
	
	public Integer updateRole(Role role);
	
	public Integer insertRole(Role role);
	
}
