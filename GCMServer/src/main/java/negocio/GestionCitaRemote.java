package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.CertificadoAusencia;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.RecetaMedica;

@Remote
public interface GestionCitaRemote {
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado);
	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado);
	public List<Cita> getCitas();
	public List<Cita> getCitasPendientes();
	public void updateCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado);
	public void updateCita(Cita c);
	public void eliminar(int ci_codigo);
	public Cita getCita(int codigo);
}
