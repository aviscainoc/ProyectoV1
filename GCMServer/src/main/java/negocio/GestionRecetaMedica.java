package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.RecetaMedicaDAO;
import modelo.Cita;
import modelo.Paciente;
import modelo.RecetaMedica;

@Stateless
public class GestionRecetaMedica implements GestionRecetaMedicaLocal, GestionRecetaMedicaRemote {
	
	@Inject
	private RecetaMedicaDAO dao;
	
	@Override
	public void guardarRecetaMedica(int rm_codigo, Paciente pa_codigo, Cita ci_codigo, String rm_medicamento,
			String rm_forma_farmaceutica, String rm_via_administracion, String rm_presentacion, int rm_cantidad,
			String rm_horario, String rm_duracion_tratamiento) {
			
		RecetaMedica rm = new RecetaMedica();
		rm.setRm_codigo(rm_codigo);
		rm.setPa_codigo(pa_codigo);
		rm.setCi_codigo(ci_codigo);
		rm.setRm_medicamento(rm_medicamento);
		rm.setRm_forma_farmaceutica(rm_forma_farmaceutica);
		rm.setRm_via_administracion(rm_via_administracion);
		rm.setRm_presentacion(rm_presentacion);
		rm.setRm_cantidad(rm_cantidad);
		rm.setRm_horario(rm_horario);
		rm.setRm_duracion_tratamiento(rm_duracion_tratamiento);
		dao.insert(rm);
	}

	@Override
	public List<RecetaMedica> listarRecetasMedicas() {
		return dao.getRecetasMedicas();
	}

	@Override
	public void actualizarRecetaMedica(int rm_codigo, Paciente pa_codigo, Cita ci_codigo, String rm_medicamento,
			String rm_forma_farmaceutica, String rm_via_administracion, String rm_presentacion, int rm_cantidad,
			String rm_horario, String rm_duracion_tratamiento) {
		
		RecetaMedica rm = new RecetaMedica();
		rm.setRm_codigo(rm_codigo);
		rm.setPa_codigo(pa_codigo);
		rm.setCi_codigo(ci_codigo);
		rm.setRm_medicamento(rm_medicamento);
		rm.setRm_forma_farmaceutica(rm_forma_farmaceutica);
		rm.setRm_via_administracion(rm_via_administracion);
		rm.setRm_presentacion(rm_presentacion);
		rm.setRm_cantidad(rm_cantidad);
		rm.setRm_horario(rm_horario);
		rm.setRm_duracion_tratamiento(rm_duracion_tratamiento);
		dao.update(rm);
		
	}

	@Override
	public void eliminarRecetaMedica(int rm_codigo) {
		// TODO Auto-generated method stub
		dao.remove(rm_codigo);
	}

}
