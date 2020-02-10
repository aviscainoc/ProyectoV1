package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.Usuario;



@Local
public interface GestionHistoriaClinicaLocal {
	public int guardarHistoriaClinica(String hc_residencia, String hc_fecha, String hc_motivo_consulta, String hc_enfermedad_actual);
	public List<HistoriaClinica> getHistoriasClinicas();
	public void update(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta, String hc_enfermedad_actual, Usuario usuario);
	public void eliminar(int codigo);
	public HistoriaClinica getHistoria(int codigo);
	
}
