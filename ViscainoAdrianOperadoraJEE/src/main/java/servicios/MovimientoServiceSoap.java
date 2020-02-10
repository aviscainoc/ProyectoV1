package servicios;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import negocio.GestionServicioRecargaLocal;



@WebService
public class MovimientoServiceSoap {

	@Inject
	private GestionServicioRecargaLocal gcl;
	
	@WebMethod
	public Respuesta realizarRecarga(String cedula, String numeroTelefono, double monto){
		Respuesta respuesta = new Respuesta();

		try {
		gcl.aprobarRecarga(cedula, numeroTelefono, monto);
		respuesta.setCodigo(1);
		respuesta.setMensaje("Aprobado");
		}catch (Exception e) {
			// TODO: handle exception
			respuesta.setCodigo(0);
			respuesta.setMensaje("Rechazado");
		}
		
		
		return respuesta;
	}

}
