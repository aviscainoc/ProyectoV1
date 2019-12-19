package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;



@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	

	public void guardarCita(int ci_codigo, Medico me_codigo, Paciente pa_codigo, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(me_codigo);
		c.setPa_codigo(pa_codigo);
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		dao.insert(c);
	}
	
	public List<Cita> getCitas(){
		return dao.getCitas();
	}
	
	public void updateCita(int ci_codigo, Medico me_codigo, Paciente pa_codigo, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(me_codigo);
		c.setPa_codigo(pa_codigo);
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		dao.update(c);
	}
	
	/*public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}*/

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}

}
