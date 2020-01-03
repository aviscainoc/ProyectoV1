package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Remote
public interface GestionCitaRemote {
	public void guardarCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String estado, String diagnostico);
	public List<Cita> getCitas();
	public void updateCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado, String ci_diagnostico);
	public void eliminar(int ci_codigo);
}
