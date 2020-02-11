package negocio;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.UsuarioDAO;
import modelo.CertificadoAusencia;
import modelo.Cita;

import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;

import modelo.RecetaMedica;



@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	@Inject
	private UsuarioDAO daoU;

	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado) {
		Cita c = new Cita();
		c.setUsuario(daoU.read(codigoU));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		c.setHistoria(historia);
		c.setExamen(examen);
		c.setReceta(receta);
		c.setCertificado(certificado);
		dao.insert(c);
		System.out.println(c);
	}

	public void guardarCita(String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, String ci_estado) {
		Cita c = new Cita();
		c.setUsuario(daoU.read(codigoU));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		c.setCi_estado(ci_estado);
		dao.insert(c);
		System.out.println(c);
	}
	
	public List<Cita> getCitas(){
		
		return dao.getCitas();
	}
	
	public List<Cita> getCitasPendientes(){
		return dao.getCitasPendientes();
	}
	

	public List<Cita> getCitasTerminadas(){
		return dao.getCitasTerminadas();
	}
	
	
	public Cita getCita(int codigo) {
		return dao.read(codigo);
	}
	
	public void updateCita(int ci_codigo, String codigoU, Date ci_fecha_agendacion, Date ci_fecha_cita, 
			String ci_estado, HistoriaClinica historia, ExamenLaboratorio examen, RecetaMedica receta, CertificadoAusencia certificado) {

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
	
	public void updateCita(Cita c) {
		dao.update(c);
	}
	
	/*public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}*/

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}
	
	public String contarCitasUsuario(String cedula){
		return dao.contarCitasPorMesUsuario(cedula);
	}
	
	public String contarCitasGeneral(){
		return dao.contarCitasPorMesGeneral();
	}
	

	public List<Cita> recuperarProximasCitas(String cedula, Date fecha){
		return dao.getProximasCitas(cedula, fecha);
	}
	
	public List<Cita> recuperarCitasPasadas(Date fecha){
		return dao.getCitasPasadas(fecha);
	}
	
	public double getSaldo() {
		return dao.getSaldo();
	}

}
