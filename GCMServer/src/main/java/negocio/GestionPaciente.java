package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.PacienteDAO;
import modelo.Paciente;

@Stateless
public class GestionPaciente implements GestionPacientesRemote, GestionPacientesLocal{

	@Inject
	private PacienteDAO dao;
	
	public void guardarUsuario(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password) {
		Paciente u = new Paciente();
		u.setUs_codigo(us_codigo);
		u.setUs_fechaNacimiento(us_fechaNacimiento);
		u.setUs_nickname(us_nickname);
		u.setUs_nombre(us_nombre);
		u.setUs_password(us_password);
		dao.insert(u);
	}

	public List<Paciente> getUsuarios() {
		return dao.getUsuarios();
	}
	

	public void update(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password) {
		Paciente u = new Paciente();
		u.setUs_codigo(us_codigo);
		u.setUs_fechaNacimiento(us_fechaNacimiento);
		u.setUs_nickname(us_nickname);
		u.setUs_nombre(us_nombre);
		u.setUs_password(us_password);
		dao.update(u);
	}

	public Paciente login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);

	}

	@Override
	public void eliminar(int us_codigo) {
		dao.remove(us_codigo);
	}

	
}
