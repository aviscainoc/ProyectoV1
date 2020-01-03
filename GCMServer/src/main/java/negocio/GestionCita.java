package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.UsuarioDAO;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;



@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	@Inject
	private UsuarioDAO daoU;

	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado, String ci_diagnostico) {
		Cita c = new Cita();
		//c.setCi_codigo(ci_codigo);
		c.setUs_usuario(daoU.read(codigoU));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		c.setCi_diagnostico(ci_diagnostico);
		dao.insert(c);
	}
	
	public List<Cita> getCitas(){
		return dao.getCitas();
	}
	
	public void updateCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado, String ci_diagnostico) {
		Cita c = new Cita();
		//c.setCi_codigo(ci_codigo);
		c.setUs_usuario(daoU.read(codigoU));
		/*c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));*/
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		c.setCi_diagnostico(ci_diagnostico);
		dao.update(c);
	}
	
	/*public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}*/

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}

}
