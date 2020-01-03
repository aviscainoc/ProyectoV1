package negocio;

import java.util.List;
import javax.ejb.Remote;

import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.Paciente;


@Remote
public interface GestionHistoriaClinicaRemote {
	public void guardarHistoriaClinica(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta, String hc_enfermedad_actual, Paciente pa_codigo);
	public List<HistoriaClinica> getHistoriasClinicas();
	public void update(int hc_codigo, String hc_residencia, String hc_fecha, String hc_motivo_consulta, String hc_enfermedad_actual, Paciente pa_codigo);
	public void eliminar(int codigo);
}
