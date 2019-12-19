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
	
	public void guardarPaciente(int pa_codigo, String pa_estado_civil, String pa_nivel_estudio, String pa_ocupacion, 
								String pa_etnia, String pa_religion, String pa_tipo_sangre, String pa_identidad_sexual, String pa_precedencia) {
		
		Paciente p = new Paciente();
		p.setPa_codigo(pa_codigo);
		p.setPa_estado_civil(pa_estado_civil);
		p.setPa_nivel_estudio(pa_nivel_estudio);
		p.setPa_ocupacion(pa_ocupacion);
		p.setPa_etnia(pa_etnia);
		p.setPa_religion(pa_religion);
		p.setPa_tipo_sangre(pa_tipo_sangre);
		p.setPa_identidad_sexual(pa_identidad_sexual);
		p.setPa_precedencia(pa_precedencia);
		dao.insert(p);
		
		p.toString();		
		
	}

	public List<Paciente> getPacientes() {
		return dao.getPacientes();
	}
	

	public void updatePaciente(int pa_codigo, String pa_estado_civil, String pa_nivel_estudio, String pa_ocupacion, 
			String pa_etnia, String pa_religion, String pa_tipo_sangre, String pa_identidad_sexual, String pa_precedencia) {
		Paciente p = new Paciente();
		p.setPa_codigo(pa_codigo);
		p.setPa_estado_civil(pa_estado_civil);
		p.setPa_nivel_estudio(pa_nivel_estudio);
		p.setPa_ocupacion(pa_ocupacion);
		p.setPa_etnia(pa_etnia);
		p.setPa_religion(pa_religion);
		p.setPa_tipo_sangre(pa_tipo_sangre);
		p.setPa_identidad_sexual(pa_identidad_sexual);
		p.setPa_precedencia(pa_precedencia);
		dao.update(p);
	}

	/*public Paciente login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);

	}*/

	@Override
	public void eliminar(int us_codigo) {
		dao.remove(us_codigo);
	}

	
}
