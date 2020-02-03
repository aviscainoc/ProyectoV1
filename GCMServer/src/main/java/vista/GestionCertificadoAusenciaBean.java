package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import modelo.*;
import negocio.GestionCertificadoAusenciaLocal;


@ManagedBean
public class GestionCertificadoAusenciaBean {
	
	@Inject
	private GestionCertificadoAusenciaLocal gl;
	
	
	private int ca_codigo;
	private String ca_descripcion;
	private List<CertificadoAusencia> CertificadoAusencias;

	public GestionCertificadoAusenciaLocal getGl() {
		return gl;
	}

	public void setGl(GestionCertificadoAusenciaLocal gl) {
		this.gl = gl;
	}

	public int getCa_codigo() {
		return ca_codigo;
	}

	public void setCa_codigo(int ca_codigo) {
		this.ca_codigo = ca_codigo;
	}

	public String getCa_descripcion() {
		return ca_descripcion;
	}

	public void setCa_descripcion(String ca_descripcion) {
		this.ca_descripcion = ca_descripcion;
	}

	public List<CertificadoAusencia> getCertificadoAusencias() {
		return CertificadoAusencias;
	}

	public void setCertificadoAusencias(List<CertificadoAusencia> certificadoAusencias) {
		CertificadoAusencias = certificadoAusencias;
	}

	public boolean guardarCertificado() {
		try {
			gl.guardarCertificadoAusencia(ca_descripcion);
			CertificadoAusencias = gl.getCertificadoAusencias();
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public List<CertificadoAusencia> recuperarCertificadoAusencias(){
		CertificadoAusencias = gl.getCertificadoAusencias();
		return CertificadoAusencias;
	}
	public void eliminar() {
		gl.eliminar(ca_codigo);
	}
	
	public void update() {
		gl.update(ca_codigo, ca_descripcion);
	}
	
	public CertificadoAusencia getCertificado(int codigo) {
		return gl.getCertificado(codigo);
	}

	@Override
	public String toString() {
		return "GestionCertificadoAusenciaBean [ca_codigo=" + ca_codigo + ", ca_descripcion=" + ca_descripcion
				+ ", CertificadoAusencias=" + CertificadoAusencias + "]";
	}

}
