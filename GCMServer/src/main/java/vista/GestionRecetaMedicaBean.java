package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.Paciente;
import modelo.RecetaMedica;
import negocio.GestionRecetaMedicaLocal;

@ManagedBean
public class GestionRecetaMedicaBean {

	@Inject
	private GestionRecetaMedicaLocal gl;
	
	private int rm_codigo;
	private Paciente pa_codigo;
	private Cita ci_codigo;
	private String rm_medicamento;
	private String rm_forma_farmaceutica;
	private String rm_via_administracion;
	private String rm_presentacion;
	private int rm_cantidad;
	private String rm_horario;
	private String rm_duracion_tratamiento;
	
	private List<RecetaMedica> recetas;

	public GestionRecetaMedicaLocal getGl() {
		return gl;
	}

	public void setGl(GestionRecetaMedicaLocal gl) {
		this.gl = gl;
	}

	public int getRm_codigo() {
		return rm_codigo;
	}

	public void setRm_codigo(int rm_codigo) {
		this.rm_codigo = rm_codigo;
	}

	public Paciente getPa_codigo() {
		return pa_codigo;
	}

	public void setPa_codigo(Paciente pa_codigo) {
		this.pa_codigo = pa_codigo;
	}

	public Cita getCi_codigo() {
		return ci_codigo;
	}

	public void setCi_codigo(Cita ci_codigo) {
		this.ci_codigo = ci_codigo;
	}

	public String getRm_medicamento() {
		return rm_medicamento;
	}

	public void setRm_medicamento(String rm_medicamento) {
		this.rm_medicamento = rm_medicamento;
	}

	public String getRm_forma_farmaceutica() {
		return rm_forma_farmaceutica;
	}

	public void setRm_forma_farmaceutica(String rm_forma_farmaceutica) {
		this.rm_forma_farmaceutica = rm_forma_farmaceutica;
	}

	public String getRm_via_administracion() {
		return rm_via_administracion;
	}

	public void setRm_via_administracion(String rm_via_administracion) {
		this.rm_via_administracion = rm_via_administracion;
	}

	public String getRm_presentacion() {
		return rm_presentacion;
	}

	public void setRm_presentacion(String rm_presentacion) {
		this.rm_presentacion = rm_presentacion;
	}

	public int getRm_cantidad() {
		return rm_cantidad;
	}

	public void setRm_cantidad(int rm_cantidad) {
		this.rm_cantidad = rm_cantidad;
	}

	public String getRm_horario() {
		return rm_horario;
	}

	public void setRm_horario(String rm_horario) {
		this.rm_horario = rm_horario;
	}

	public String getRm_duracion_tratamiento() {
		return rm_duracion_tratamiento;
	}

	public void setRm_duracion_tratamiento(String rm_duracion_tratamiento) {
		this.rm_duracion_tratamiento = rm_duracion_tratamiento;
	}

	public List<RecetaMedica> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<RecetaMedica> recetas) {
		this.recetas = recetas;
	}
	
	public String guardarRecetas() {
		System.out.println(rm_codigo + " "+ rm_medicamento);
		gl.guardarRecetaMedica(rm_codigo, pa_codigo, ci_codigo, rm_medicamento, rm_forma_farmaceutica, rm_via_administracion, rm_presentacion, rm_cantidad, rm_horario, rm_duracion_tratamiento);
		recetas = gl.listarRecetasMedicas();
		return "principal";
	}
	
	public List<RecetaMedica> recuperarRecetas(){
		recetas = gl.listarRecetasMedicas();
		return recetas;
	}
	
	public void eliminar() {
		gl.eliminarRecetaMedica(rm_codigo);
	}
	
	public void update() {
		gl.actualizarRecetaMedica(rm_codigo, pa_codigo, ci_codigo, rm_medicamento, rm_forma_farmaceutica, rm_via_administracion, rm_presentacion, rm_cantidad, rm_horario, rm_duracion_tratamiento);
	}
	
}
