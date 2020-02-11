package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.CertificadoAusencia;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.RecetaMedica;

@Local
public interface GestionCitaLocal {
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado);
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado);
	public List<Cita> getCitas();
	public List<Cita> getCitasPendientes();
	public void updateCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado);
	public void updateCita(Cita c);
	public void eliminar(int ci_codigo);
	public List<Cita> recuperarProximasCitas(String cedula, Date fecha);
	public Cita getCita(int codigo);
	public List<Cita> recuperarCitasPasadas(Date fecha);
	public String contarCitasGeneral();
	public String contarCitasUsuario(String cedula);
	public double getSaldo();
}
