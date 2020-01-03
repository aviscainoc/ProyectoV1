package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Local
public interface GestionCitaLocal {
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String estado, String diagnostico);
	public List<Cita> getCitas();
	public void updateCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado, String ci_diagnostico);
	public void eliminar(int ci_codigo);

}
