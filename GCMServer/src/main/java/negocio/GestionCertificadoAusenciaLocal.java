package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.CertificadoAusencia;
import modelo.Cita;




@Local
public interface GestionCertificadoAusenciaLocal {
	public int guardarCertificadoAusencia(String ca_descripcion);
	public List<CertificadoAusencia> getCertificadoAusencias();
	public void update(int ca_codigo, String ca_descripcion);
	public void eliminar(int codigo);
	public CertificadoAusencia getCertificado(int codigo);
	public int obtenerCodigoCertificado(int codigo);
	public String obtenerTexto(int codigoCA);
	
}
