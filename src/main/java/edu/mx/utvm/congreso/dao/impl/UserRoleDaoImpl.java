package edu.mx.utvm.congreso.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IUserRoleDao;
import edu.mx.utvm.congreso.dominio.UserRole;
@Repository
public class UserRoleDaoImpl extends JdbcTemplate implements IUserRoleDao{
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(UserRole newInstance) {
		this.update(
				"INSERT INTO "
						+ "USER_ROLES"
						+ "(USER_ID, AUTHORITY) "
						+ "VALUES(?,?)",
				new Object[] {
					newInstance.getUserId(),
					newInstance.getAuthority()
				});
	}

	@Override
	public UserRole read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserRole transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRole persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
