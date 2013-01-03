package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IParticipationDao;
import edu.mx.utvm.congreso.dominio.Participation;
@Repository
public class ParticipationDaoImpl extends JdbcTemplate implements IParticipationDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Participation newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Participation read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Participation transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Participation persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Participation> findAll() {
		String sql = "SELECT * FROM participation";
		List<Participation> result = this.query(sql, new RowMapper<Participation>() {
			@Override
			public Participation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Participation participation = new Participation();
				participation.setId(rs.getInt("ID"));
				participation.setName(rs.getString("NAME"));
				return participation;
			}
		});
		return result;
	}

}
