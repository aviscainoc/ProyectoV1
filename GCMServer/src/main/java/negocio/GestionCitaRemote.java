package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

@Remote
public interface GestionCitaRemote {
	public void guardarCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita);
	public List<Cita> getCitas();
	public void updateCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita);
	public void eliminar(int ci_codigo);
}
