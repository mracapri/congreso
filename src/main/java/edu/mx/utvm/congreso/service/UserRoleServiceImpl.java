package edu.mx.utvm.congreso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.UserRoleDaoImpl;
import edu.mx.utvm.congreso.dominio.UserRole;
@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private UserRoleDaoImpl daoImpl;
	
	@Override
	public void save(UserRole role) {
		daoImpl.create(role);
	}

	@Override
	public UserRole read(String id) {
		return daoImpl.read(id);
	}

	@Override
	public void update(UserRole userRole) {
		daoImpl.update(userRole);
	}

}
