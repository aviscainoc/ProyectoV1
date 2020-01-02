package negocio;

import java.util.Date;
import java.util.List;

import modelo.Usuario;

public interface GestionUsuariosLocal {
	 public void guardarUsuarioPaciente(String us_cedula, String us_rol, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
				String us_correo, String us_contrasena, String us_pa_estado_civil, String us_pa_nivel_estudio, String us_pa_ocupacion, String us_pa_etnia, 
				String us_pa_religion, String us_pa_tipo_sangre, String us_pa_identidad_sexual, String us_pa_procedencia);
	 public void guardarUsuarioMedico(String us_cedula, String us_rol, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
				String us_correo, String us_contrasena, String us_md_area_especialidad, String us_md_descripcion); 
	 public List<Usuario> getUsuarios(); 
	 public Usuario login(String usuario, String contrasena) throws Exception;

}