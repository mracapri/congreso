package edu.mx.utvm.congreso.service;

import edu.mx.utvm.congreso.dominio.ChartParticipationRegister;
import edu.mx.utvm.congreso.dominio.ChartPreregisterStatus;

public interface ChartService {
	ChartPreregisterStatus getDataToChartPreregisterStatus();
	ChartParticipationRegister getDataToChartParticipationRegister();
}
