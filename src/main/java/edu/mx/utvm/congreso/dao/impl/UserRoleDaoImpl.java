package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
						+ "user_roles"
						+ "(USER_ID, AUTHORITY) "
						+ "VALUES(?,?)",
				new Object[] {
					newInstance.getUserId(),
					newInstance.getAuthority()
				});
	}

	@Override
	public UserRole read(String id) {
		String sql = "select user_id, authority from user_roles where user_id = ?";
		try {
			UserRole resultado = this.queryForObject(sql,
					new Object[] { id },
					new RowMapper<UserRole>() {
						@Override
						public UserRole mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							UserRole role = new UserRole(); 
							role.setAuthority(rs.getString("authority"));
							role.setUserId(rs.getString("user_id"));
							return role;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(UserRole transientObject) {
		this.update(
				"UPDATE user_roles SET AUTHORITY = ? WHERE USER_ID = ?",
				new Object[] {
						transientObject.getAuthority(),
						transientObject.getUserId()
				});		
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
