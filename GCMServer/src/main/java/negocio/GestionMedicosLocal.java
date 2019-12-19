package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Medico;

@Local
public interface GestionMedicosLocal {
	public void guardarMedico(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	public List<Medico> getMedicos();
	public void update(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	//public Medico Login(String usuario, String contraseña);
	public void eliminar(int codigo);
	
	
}
