	package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.OneToMany;

import datos.CitaDAO;
import datos.ExamenLaboratorioDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.UsuarioDAO;
import modelo.Cita;
import modelo.HistoriaClinica;
import modelo.Usuario;

@Stateless
public class GestionUsuario implements GestionUsuariosLocal, GestionUsuariosRemote {
	
	@Inject 
	private UsuarioDAO daoU;
	@Inject 
	ExamenLaboratorioDAO daoEL;
	@Inject
	private CitaDAO daoC;
	
	public void guardarUsuarioPaciente(String us_cedula, String us_rol, int us_pa_registro, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
			String us_correo, String us_contrasena, String us_pa_estado_civil, String us_pa_nivel_estudio, String us_pa_ocupacion, String us_pa_etnia, 
			String us_pa_religion, String us_pa_tipo_sangre, String us_pa_identidad_sexual, String us_pa_procedencia) {		
		Usuario u = new Usuario();
		u.setUs_cedula(us_cedula);
		u.setUs_rol(us_rol);
		u.setUs_pa_registro(us_pa_registro);
		u.setUs_nombres(us_nombres);
		u.setUs_apellidos(us_apellidos);
		u.setUs_sexo(us_sexo);
		u.setUs_fecha_nacimiento(us_fecha_nacimiento);
		u.setUs_correo(us_correo);
		u.setUs_contrasena(us_contrasena);
		u.setUs_pa_estado_civil(us_pa_estado_civil);
		u.setUs_pa_nivel_estudio(us_pa_nivel_estudio);
		u.setUs_pa_ocupacion(us_pa_ocupacion);
		u.setUs_pa_etnia(us_pa_etnia);
		u.setUs_pa_religion(us_pa_religion);
		u.setUs_pa_tipo_sangre(us_pa_tipo_sangre);
		u.setUs_pa_identidad_sexual(us_pa_identidad_sexual);
		u.setUs_pa_procedencia(us_pa_procedencia);
		System.out.println(u);
		daoU.insert(u);
	}
	
	public void guardarUsuarioMedico(String us_cedula, String us_rol, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
			String us_correo, String us_contrasena, String us_md_area_especialidad, String us_md_descripcion) {
		
		Usuario u = new Usuario();
		u.setUs_cedula(us_cedula);
		u.setUs_rol(us_rol);
		u.setUs_nombres(us_nombres);
		u.setUs_apellidos(us_apellidos);
		u.setUs_sexo(us_sexo);
		u.setUs_fecha_nacimiento(us_fecha_nacimiento);
		u.setUs_correo(us_correo);
		u.setUs_contrasena(us_contrasena);
		u.setUs_md_area_especialidad(us_md_area_especialidad);
		u.setUs_md_descripcion(us_md_descripcion);
		daoU.insert(u);
		//return index';
	}
		
	public List<Usuario> getUsuarios(){
		return daoU.getUsuarios();
	}
	
	public Usuario login(String usuario, String contrasena) throws Exception {
		Usuario usr= daoU.login(usuario, contrasena);
		
		return usr;
	}
	
	public Usuario recuperarUsuario(String cedula) {
		System.out.println("mostrando a "+daoU.read(cedula));
		
		return daoU.read(cedula);
	}


	
	
}



/*


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
	}

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}*/