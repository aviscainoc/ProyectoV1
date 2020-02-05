package negocio;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.UsuarioDAO;
import modelo.Cita;
import modelo.ConteoCitas;
import modelo.Medico;
import modelo.Paciente;



@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	@Inject
	private UsuarioDAO daoU;

	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado) {
		Cita c = new Cita();
		//c.setCi_codigo(ci_codigo);
		c.setUsuario(daoU.read(codigoU));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		dao.insert(c);
	}
	
	public List<Cita> getCitas(){
		System.out.println("Impresion de las citas");
		System.out.println(dao.contarCitasPorMesUsuario("0106171325").toString());
		
		return dao.getCitas();
	}
	
	public List<Cita> getCitasPendientes(){
		return dao.getCitasPendientes();
	}
	
	public List<Cita> getCitasTerminadas(){
		return dao.getCitasTerminadas();
	}
	
	public void updateCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado) {
		Cita c = new Cita();
		//c.setCi_codigo(ci_codigo);
		c.setUsuario(daoU.read(codigoU));
		/*c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));*/
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		dao.update(c);
	}
	
	/*public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}*/

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}
	
	public List<ConteoCitas> contarCitasUsuario(String cedula){
		
		return dao.contarCitasPorMesUsuario(cedula);
	}
	
	public List<ConteoCitas> contarCitasGeneral(){
		
		return dao.contarCitasPorMesGeneral();
	}
	
	public List<Cita> recuperarProximasCitas(Date fecha){
		
		return dao.getProximasCitas(fecha);
		
	}

}
