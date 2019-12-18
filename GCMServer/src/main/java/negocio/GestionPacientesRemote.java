package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Paciente;

@Remote
public interface GestionPacientesRemote {

	public void guardarUsuario(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	public List<Paciente> getUsuarios();
	public void update(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	public Paciente login(String usuario, String contrasena);
	public void eliminar(int codigo);

}
