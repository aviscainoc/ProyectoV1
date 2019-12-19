package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Paciente;

@Local
public interface GestionPacientesLocal {
	public void guardarPaciente(int pa_codigo, String pa_estado_civil, String pa_nivel_estudio, String pa_ocupacion, 
			String pa_etnia, String pa_religion, String pa_tipo_sangre, String pa_identidad_sexual, String pa_precedencia);
	public List<Paciente> getPacientes();
	public void updatePaciente(int pa_codigo, String pa_estado_civil, String pa_nivel_estudio, String pa_ocupacion, 
			String pa_etnia, String pa_religion, String pa_tipo_sangre, String pa_identidad_sexual, String pa_precedencia) ;
	public void eliminar(int codigo);
}
