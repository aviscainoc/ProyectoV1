package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Remote
public interface GestionCitaRemote {
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String estado);
	public List<Cita> getCitas();
	public List<Cita> getCitasPendientes();
	public void updateCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado);
	public void eliminar(int ci_codigo);
}
