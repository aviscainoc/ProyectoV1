package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Local
public interface GestionCitaLocal {
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String estado);
	public List<Cita> getCitas();
	public List<Cita> getCitasPendientes();
	public void updateCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado);
	public void eliminar(int ci_codigo);
	
	
	public List<Cita> recuperarProximasCitas(Date fecha);

}
