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

import edu.mx.utvm.congreso.dao.IChartDao;
import edu.mx.utvm.congreso.dominio.ChartData;
import edu.mx.utvm.congreso.dominio.ChartParticipationRegister;
import edu.mx.utvm.congreso.dominio.ChartPreregisterStatus;
@Repository
public class ChartDaoImpl extends JdbcTemplate implements IChartDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(ChartData newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChartData read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ChartData transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ChartData persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChartData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ChartPreregisterStatus getDataToChartPreregisterStatus() {
	    String sql = "select ";
	    sql = sql + 	"(select count(*) from preregister_information where payment_status = 'PAGADO') as pay,  ";
	    sql = sql + 	"(select count(*) from preregister_information where payment_status = 'NO_PAGADO') as no_pay";
		try {
			ChartPreregisterStatus result = this.queryForObject(sql,
					new Object[] { },
					new RowMapper<ChartPreregisterStatus>() {
						@Override
						public ChartPreregisterStatus mapRow(ResultSet rs,
								int rowNum) throws SQLException {

							ChartPreregisterStatus data = new ChartPreregisterStatus();
							data.setNoPay(rs.getInt("no_pay"));
							data.setPay(rs.getInt("pay"));
							return data;
						}
					});
			return result;
		} catch (EmptyResultDataAccessException accessException) {
			return new ChartPreregisterStatus();
		}
	}

	@Override
	public ChartParticipationRegister getDataToChartParticipationRegister() {
	    String sql = "select ";
	    sql = sql + 	"(select count(*) from participation_register_information) as participation,  ";
	    sql = sql + 	"(select count(*) from academy_information) as academy ";
		try {
			ChartParticipationRegister result = this.queryForObject(sql,
					new Object[] { },
					new RowMapper<ChartParticipationRegister>() {
						@Override
						public ChartParticipationRegister mapRow(ResultSet rs,
								int rowNum) throws SQLException {

							ChartParticipationRegister data = new ChartParticipationRegister();
							data.setNumberOfAcademicBodies(rs.getInt("academy"));
							data.setNumberOfParticipants(rs.getInt("participation"));
							return data;
						}
					});
			return result;
		} catch (EmptyResultDataAccessException accessException) {
			return new ChartParticipationRegister();
		}
	}

}
