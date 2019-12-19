package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicoDAO;
import modelo.Medico;
import modelo.Paciente;

@Stateless
public class GestionMedico implements GestionMedicosRemote, GestionMedicosLocal {

	@Inject
	private MedicoDAO dao;
	
	public void guardarMedico(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password) {
		Medico u = new Medico();
		u.setMd_id(us_codigo);
		u.setMd_fechaNacimiento(us_fechaNacimiento);
		u.setMd_usuario(us_nickname);
		u.setMd_nombre(us_nombre);
		u.setMd_password(us_password);
		dao.insert(u);
	}
	
	public List<Medico> getMedicos(){
		return dao.getMedicos();
	}
	
	public void update(int us_codigo, String us_nombre, String us_fechaNacimiento, String us_nickname, String us_password) {
		Medico u = new Medico();
		u.setMd_id(us_codigo);
		u.setMd_fechaNacimiento(us_fechaNacimiento);
		u.setMd_usuario(us_nickname);
		u.setMd_nombre(us_nombre);
		u.setMd_password(us_password);
		dao.update(u);
	}
	
	public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}

	public void eliminar(int us_codigo) {
		dao.remove(us_codigo);
	}
}
