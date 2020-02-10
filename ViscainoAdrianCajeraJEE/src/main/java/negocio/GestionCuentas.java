package negocio;


import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CuentaDAO;
import modelo.Cuenta;

@Stateless
public class GestionCuentas implements GestionCuentasLocal {
	
	@Inject CuentaDAO daoC;
	
	public boolean crearCuenta(String numeroCuenta, double monto ) {
		Cuenta cnt = new Cuenta();
		cnt.setCedula(numeroCuenta);
		cnt.setSaldo(monto);
		
		System.out.println(cnt);
		daoC.insert(cnt);
		return true;
		
	}
	
	
	public Cuenta mostrarCuenta(String numCuenta) {
		System.out.println("mostrando a"+daoC.read(numCuenta));
		
		return daoC.read(numCuenta);
		
	}


}
