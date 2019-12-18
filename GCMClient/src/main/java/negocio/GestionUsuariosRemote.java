package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Usuario;

@Remote
public interface GestionUsuariosRemote {

	public void guardarUsuario(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	public List<Usuario> getUsuarios();
	public void update(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password);
	public Usuario login(String usuario, String contrasena);

}
