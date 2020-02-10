package vista;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import modelo.*;
import negocio.GestionCuentasLocal;


@ManagedBean
public class GestionCuentasBean {
	
	@Inject
	private GestionCuentasLocal gl;
	
	
	private String cedula;
	
	private double saldo;

	public GestionCuentasLocal getGl() {
		return gl;
	}

	public void setGl(GestionCuentasLocal gl) {
		this.gl = gl;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void guardarCuenta() {
		if(gl.crearCuenta(cedula, saldo)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", cedula);
            facesContext.addMessage(null, m);
            return;
		
		}
	
	}
	

}
