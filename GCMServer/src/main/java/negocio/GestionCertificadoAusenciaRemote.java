package negocio;

import java.util.List;
import javax.ejb.Remote;

import modelo.CertificadoAusencia;
import modelo.Cita;

@Remote
public interface GestionCertificadoAusenciaRemote {
	public int guardarCertificadoAusencia(String ca_descripcion);
	public List<CertificadoAusencia> getCertificadoAusencias();
	public void update(int ca_codigo, String ca_descripcion);
	public void eliminar(int codigo);
	public CertificadoAusencia getCertificado(int codigo);
}
