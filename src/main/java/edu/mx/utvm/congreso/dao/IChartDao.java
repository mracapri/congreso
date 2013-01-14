package edu.mx.utvm.congreso.dao;

import edu.mx.utvm.congreso.dominio.ChartData;
import edu.mx.utvm.congreso.dominio.ChartPreregisterStatus;

public interface IChartDao extends Dao<ChartData, Integer>{
	ChartPreregisterStatus getDataToChart();
}
