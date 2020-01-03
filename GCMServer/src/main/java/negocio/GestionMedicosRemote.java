package negocio;

import java.util.List;
import javax.ejb.Remote;
import modelo.Medico;

@Remote
public interface GestionMedicosRemote {
	public void guardarMedico(int us_codigo, String us_nombre, String us_apellidos, String us_fechaNacimiento, String us_correo, String us_password, String us_descripcion, String us_area_especializacion);
	public List<Medico> getMedicos();
	public void update(int us_codigo, String us_nombre, String us_apellidos, String us_fechaNacimiento, String us_correo, String us_password, String us_descripcion, String us_area_especializacion);
	//public Medico Login(String usuario, String contraseña);
	public void eliminar(int codigo);
}
