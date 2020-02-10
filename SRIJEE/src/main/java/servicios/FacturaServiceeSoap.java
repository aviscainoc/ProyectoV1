package servicios;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import negocio.GestionSRILocal;



@WebService
public class FacturaServiceeSoap {

	@Inject
	private GestionSRILocal gcl;
	
	@WebMethod
	public RespuestaFac realizarRecargaFactura(String cedula, int numFactura, double valor){
		RespuestaFac respuesta = new RespuestaFac();

		try {
		gcl.aprobarFactura(cedula, numFactura, valor);
		respuesta.setCodigo(1);
		respuesta.setMensaje(gcl.aprobarFactura(cedula, numFactura, valor));
		}catch (Exception e) {
			// TODO: handle exception
			respuesta.setCodigo(0);
			respuesta.setMensaje("Rechazado");
		}
		
		
		return respuesta;
	}

}
