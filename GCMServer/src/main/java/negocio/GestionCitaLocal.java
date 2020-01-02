package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Local
public interface GestionCitaLocal {
	public void guardarCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita);
	public List<Cita> getCitas();
	public void updateCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita);
	public void eliminar(int ci_codigo);

}
