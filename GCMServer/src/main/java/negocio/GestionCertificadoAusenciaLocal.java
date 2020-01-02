package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.CertificadoAusencia;
import modelo.Cita;




@Local
public interface GestionCertificadoAusenciaLocal {
	public void guardarCertificadoAusencia(int ca_codigo, Cita ci_codigo, String ca_descripcion);
	public List<CertificadoAusencia> getCertificadoAusencias();
	public void update(int ca_codigo, Cita ci_codigo, String ca_descripcion);
	public void eliminar(int codigo);
	
	
}
