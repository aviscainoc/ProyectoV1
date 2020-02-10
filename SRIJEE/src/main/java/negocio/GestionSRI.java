package negocio;


import javax.ejb.Stateless;
import javax.inject.Inject;



@Stateless
public class GestionSRI implements GestionSRILocal {
	
	
	
	public String aprobarFactura(String cedula, int numFactura, double valorF ) {
		
		String uuid = "";
		
		boolean bandera = false;
		 int valorDado = (int) Math.floor(Math.random()*3+2);
		System.out.println("valor aleatorio"+valorDado);
		
		if(valorDado == 3 ) {
			bandera = true;
			uuid = java.util.UUID.randomUUID().toString();
			System.out.println(uuid);
		}else
			if(valorDado==2) {
				bandera = false;
			}
		return uuid;
		
	}
	
	



}
