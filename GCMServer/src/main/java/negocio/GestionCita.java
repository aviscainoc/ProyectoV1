package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;



@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	@Inject
	private MedicoDAO daoM;
	@Inject
	private PacienteDAO daoP;

	public void guardarCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		dao.insert(c);
	}
	
	public List<Cita> getCitas(){
		return dao.getCitas();
	}
	
	public void updateCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));
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
