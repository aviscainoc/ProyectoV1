package negocio;

import modelo.Cuenta;

public interface GestionCuentasLocal {
	public boolean crearCuenta(String numeroCuenta, double monto );
	public Cuenta mostrarCuenta(String numCuenta);
	
}
