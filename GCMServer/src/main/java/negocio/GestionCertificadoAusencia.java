package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CertificadoAusenciaDAO;
import datos.CitaDAO;
import modelo.CertificadoAusencia;
import modelo.Cita;




@Stateless
public class GestionCertificadoAusencia implements GestionCertificadoAusenciaRemote, GestionCertificadoAusenciaLocal {

	@Inject
	private CertificadoAusenciaDAO dao;
	@Inject
	private CitaDAO daoC;
	
	
	public int guardarCertificadoAusencia(String ca_descripcion) {
		CertificadoAusencia u = new CertificadoAusencia();
		u.setCa_descripcion(ca_descripcion);
		dao.insert(u);
		System.out.println(u);
		return u.getca_codigo();
	}
	
	public List<CertificadoAusencia> getCertificadoAusencias(){
		return dao.getCertificados();
	}
	
	public void update(int ca_codigo, String ca_descripcion) {
		CertificadoAusencia u = new CertificadoAusencia();
		u.setCa_codigo(ca_codigo);
		u.setCa_descripcion(ca_descripcion);
		dao.update(u);
	}
	

	public void eliminar(int ca_codigo) {
		dao.remove(ca_codigo);
	}
	
	public CertificadoAusencia getCertificado(int codigo) {
		return dao.read(codigo);
	}
	
	public int obtenerCodigoCertificado(int codigo) {
		System.out.println(daoC.obtenerCodigoCertificado(codigo));
		return daoC.obtenerCodigoCertificado(codigo);
	}
	
	public String obtenerTexto(int codigoCA) {
		String texto = dao.obtenerTextoCA(codigoCA);
		return texto;
	}
}
