package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ExamenLaboratorioDAO;
import datos.HistoriaClinicaDAO;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.Paciente;



@Stateless
public class GestionHistoriaClinica implements GestionHistoriaClinicaRemote, GestionHistoriaClinicaLocal {

	@Inject
	private HistoriaClinicaDAO dao;

	@Override
	public void guardarHistoriaClinica(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta,
			String hc_enfermedad_actual, Paciente pa_codigo) {
		HistoriaClinica hc = new HistoriaClinica();
		hc.setHc_codigo(hc_codigo);
		hc.setHc_residencia(hc_residencia);
		hc.setHc_fecha(hc_fecha);
		hc.setHc_movito_consulta(hc_motivo_consulta);
		hc.setHc_enfermedad_actual(hc_enfermedad_actual);
		hc.setPa_codigo(pa_codigo);
		dao.insert(hc);
	}

	@Override
	public List<HistoriaClinica> getHistoriasClinicas() {
		// TODO Auto-generated method stub
		return dao.getHistoriasClinicas();
	}

	@Override
	public void update(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta,
			String hc_enfermedad_actual, Paciente pa_codigo) {
		
		HistoriaClinica hc = new HistoriaClinica();
		hc.setHc_codigo(hc_codigo);
		hc.setHc_residencia(hc_residencia);
		hc.setHc_fecha(hc_fecha);
		hc.setHc_movito_consulta(hc_motivo_consulta);
		hc.setHc_enfermedad_actual(hc_enfermedad_actual);
		hc.setPa_codigo(pa_codigo);
		dao.update(hc);
		
	}

	@Override
	public void eliminar(int codigo) {
		// TODO Auto-generated method stub
		dao.remove(codigo);
	}
	
	
}
