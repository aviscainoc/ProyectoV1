package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ExamenLaboratorioDAO;
import datos.HistoriaClinicaDAO;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.Usuario;



@Stateless
public class GestionHistoriaClinica implements GestionHistoriaClinicaRemote, GestionHistoriaClinicaLocal {

	@Inject
	private HistoriaClinicaDAO dao;

	@Override
	public int guardarHistoriaClinica(String hc_residencia, String hc_fecha, String hc_motivo_consulta,
			String hc_enfermedad_actual, Usuario usuario) {
		System.out.println("Entra a gestionH");
		HistoriaClinica hc = new HistoriaClinica();
		hc.setHc_residencia(hc_residencia);
		hc.setHc_fecha(hc_fecha);
		hc.setHc_movito_consulta(hc_motivo_consulta);
		hc.setHc_enfermedad_actual(hc_enfermedad_actual);
		System.out.println("problemas usuario");
		hc.setUsuario(usuario);
		System.out.println("recupera datos "+hc_enfermedad_actual);
		dao.insert(hc);
		System.out.println(hc);
		System.out.println("codigo de historia"+hc.getHc_codigo());
		return hc.getHc_codigo();
	}

	@Override
	public List<HistoriaClinica> getHistoriasClinicas() {
		// TODO Auto-generated method stub
		return dao.getHistoriasClinicas();
	}

	@Override
	public void update(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta,
			String hc_enfermedad_actual, Usuario usuario) {
		
		HistoriaClinica hc = new HistoriaClinica();
		hc.setHc_codigo(hc_codigo);
		hc.setHc_residencia(hc_residencia);
		hc.setHc_fecha(hc_fecha);
		hc.setHc_movito_consulta(hc_motivo_consulta);
		hc.setHc_enfermedad_actual(hc_enfermedad_actual);
		hc.setUsuario(usuario);
		dao.update(hc);
		
	}

	@Override
	public void eliminar(int codigo) {
		// TODO Auto-generated method stub
		dao.remove(codigo);
	}
	
	public HistoriaClinica getHistoria(int codigo) {
		return dao.read(codigo);
	}
	
	
}
