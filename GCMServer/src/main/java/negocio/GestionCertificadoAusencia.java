package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CertificadoAusenciaDAO;
import modelo.CertificadoAusencia;
import modelo.Cita;




@Stateless
public class GestionCertificadoAusencia implements GestionCertificadoAusenciaRemote, GestionCertificadoAusenciaLocal {

	@Inject
	private CertificadoAusenciaDAO dao;
	
	
	public void guardarCertificadoAusencia(int ca_codigo,  Cita ci_codigo, String ca_descripcion) {
		CertificadoAusencia u = new CertificadoAusencia();
		u.setCa_codigo(ca_codigo);
		u.setCi_codigo(ci_codigo);
		u.setCa_descripcion(ca_descripcion);
		dao.insert(u);
	}
	
	public List<CertificadoAusencia> getCertificadoAusencias(){
		return dao.getCitas();
	}
	
	public void update(int ca_codigo,  Cita ci_codigo, String ca_descripcion) {
		CertificadoAusencia u = new CertificadoAusencia();
		u.setCa_codigo(ca_codigo);
		u.setCi_codigo(ci_codigo);
		u.setCa_descripcion(ca_descripcion);
		dao.update(u);
	}
	

	public void eliminar(int ca_codigo) {
		dao.remove(ca_codigo);
	}
}
