package negocio;

import java.util.List;

import javax.ejb.Remote;
import modelo.Cita;
import modelo.*;

@Remote
public interface GestionRecetaMedicaRemote {
	public void guardarRecetaMedica(int rm_codigo, Paciente pa_codigo, Cita ci_codigo, String rm_medicamento, String rm_forma_farmaceutica, String rm_via_administracion, String rm_presentacion, int rm_cantidad, String rm_horario, String rm_duracion_tratamiento);
	public List<RecetaMedica> listarRecetasMedicas();
	public void actualizarRecetaMedica(int rm_codigo, Paciente pa_codigo, Cita ci_codigo, String rm_medicamento, String rm_forma_farmaceutica, String rm_via_administracion, String rm_presentacion, int rm_cantidad, String rm_horario, String rm_duracion_tratamiento);
	public void eliminarRecetaMedica(int rm_codigo);
}
