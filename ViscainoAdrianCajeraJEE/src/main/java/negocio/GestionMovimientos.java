package negocio;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import datos.CuentaDAO;
import datos.MovimientoDAO;
import modelo.Cuenta;
import modelo.Movimiento;

@Stateless
public class GestionMovimientos implements GestionMovimientosLocal {
	@Inject
	private MovimientoDAO daoM;
	@Inject
	private CuentaDAO daoC;
	
	public void Transaccion(String numCuenta, int numeroFactura, int clave, int valor) {
		 
		
		
	
		
	
		Movimiento mov = new Movimiento();
		Cuenta cuenta = daoC.read(numCuenta);
		
		System.out.printf("Saldo original origen", cuenta.getSaldo());
		cuenta.setSaldo(cuenta.getSaldo()-valor);
		daoC.update(cuenta);	
		System.out.printf("Saldo nuevo origen", cuenta.getSaldo());
	
		
		//Creacion del movimietno 
		mov.setCuentaOrigen(cuenta);
		mov.setNumFactura(numeroFactura);
		mov.setClaveAccs(clave);
		mov.setValorRec(valor);
		daoM.insert(mov);
		
		
	}
	

}
