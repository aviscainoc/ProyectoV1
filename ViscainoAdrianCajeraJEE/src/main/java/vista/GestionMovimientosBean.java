package vista;

import javax.faces.bean.ManagedBean;

import negocio.GestionMovimientosLocal;
import servicios.MovimientoServiceSoap_MovimientoServiceSoapPort_Client;
//import servicios1.FacturaServiceeSoap_FacturaServiceeSoapPort_Client;
import servicios1.FacturaServiceeSoap_FacturaServiceeSoapPort_Client;

@ManagedBean

public class GestionMovimientosBean {


	private GestionMovimientosLocal gml;
	
	private MovimientoServiceSoap_MovimientoServiceSoapPort_Client mov = new MovimientoServiceSoap_MovimientoServiceSoapPort_Client();
	private FacturaServiceeSoap_FacturaServiceeSoapPort_Client fac = new FacturaServiceeSoap_FacturaServiceeSoapPort_Client();	
	
	private String numeroCuenta;
	
	private int numFactura;
	
	private int claveAccs;
	
	private int valorRec;
	
	private String celular;
	

	
	public GestionMovimientosLocal getGml() {
		return gml;
	}

	public void setGml(GestionMovimientosLocal gml) {
		this.gml = gml;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public int getClaveAccs() {
		return claveAccs;
	}

	public void setClaveAccs(int claveAccs) {
		this.claveAccs = claveAccs;
	}

	public int getValorRec() {
		return valorRec;
	}

	public void setValorRec(int valorRec) {
		this.valorRec = valorRec;
	}
	
	public void guardarMovimiento() {
		gml.Transaccion(numeroCuenta, numFactura, claveAccs, valorRec);
	}
	
	public void validarMovimiento() {
	 System.out.println(mov.metodo(numeroCuenta, celular, valorRec));
	 System.out.println(numeroCuenta);
	 System.out.println(celular);
	 System.out.println(valorRec);
	 mov.metodo(numeroCuenta, celular, valorRec);
	 if(	 mov.metodo(numeroCuenta, celular, valorRec)==1) {
		 fac.generarUuid();
		 
	 }
	 mov.metodo(numeroCuenta, celular, valorRec);	
	}
	
	public void verFac() {
		System.out.println(fac.generarUuid());
		fac.generarUuid();
	}
	
	
	
}
