package negocio;


import javax.ejb.Stateless;
import javax.inject.Inject;



@Stateless
public class GestionServicioRecarga implements GestionServicioRecargaLocal {
	
	
	
	public boolean aprobarRecarga(String cedula, String numeroTelefono, double monto ) {
		boolean bandera = false;
		 int valorDado = (int) Math.floor(Math.random()*3+2);
		System.out.println("valor aleatorio"+valorDado);
		
		if(valorDado == 3 ) {
			bandera = true;
		}else
			if(valorDado==2) {
				bandera = false;
			}
		return bandera;
		
	}
	
	



}
