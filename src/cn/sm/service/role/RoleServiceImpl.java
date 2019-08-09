package cn.sm.service.role;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm.dao.role.RoleMapper;
import cn.sm.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper rm;

	@Override
	public List<Role> findAllRole(Role role) {
		List<Role > rlist=rm.findAllRole(role);
		List<Role> elist=new ArrayList<Role>(); 
		for (Role role2 : rlist) {
			 role=new Role();
			 role.setId(role2.getId());
			role.setRoleCode(role2.getRoleCode());
			role.setRoleName(role2.getRoleName());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			role.setDate(sdf.format(role2.getCreationDate()));
			elist.add(role);
		}
		return elist;
	}

	@Override
	public boolean delectRole(Role role) {
		if (rm.delectRole(role)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateRole(Role role) {
		if (rm.updateRole(role)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean insertRole(Role role) {
		if (rm.insertRole(role)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
