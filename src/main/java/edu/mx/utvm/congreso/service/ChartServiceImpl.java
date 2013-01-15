package edu.mx.utvm.congreso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.ChartDaoImpl;
import edu.mx.utvm.congreso.dominio.ChartParticipationRegister;
import edu.mx.utvm.congreso.dominio.ChartPreregisterStatus;
@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartDaoImpl chartDao;

	@Override
	public ChartPreregisterStatus getDataToChartPreregisterStatus() {
		return chartDao.getDataToChartPreregisterStatus();
	}

	@Override
	public ChartParticipationRegister getDataToChartParticipationRegister() {
		return chartDao.getDataToChartParticipationRegister();
	}

}
