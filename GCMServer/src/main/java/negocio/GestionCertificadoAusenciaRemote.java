package negocio;

import java.util.List;
import javax.ejb.Remote;

import modelo.CertificadoAusencia;
import modelo.Cita;

@Remote
public interface GestionCertificadoAusenciaRemote {
	public void guardarCertificadoAusencia(int ca_codigo, Cita ci_codigo, String ca_descripcion);
	public List<CertificadoAusencia> getCertificadoAusencias();
	public void update(int ca_codigo, Cita ci_codigo, String ca_descripcion);
	public void eliminar(int codigo);
}
