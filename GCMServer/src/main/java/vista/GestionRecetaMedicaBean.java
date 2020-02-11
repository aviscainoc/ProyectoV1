package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.RecetaMedica;
import negocio.GestionRecetaMedicaLocal;

@ManagedBean
public class GestionRecetaMedicaBean {

	@Inject
	private GestionRecetaMedicaLocal gl;
	
	private int rm_codigo;
	private String rm_peso;
	private String rm_talla;
	private String rm_edad;
	private String rm_TA;
	private String rm_rx;
	
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

	public String getRm_peso() {
		return rm_peso;
	}

	public void setRm_peso(String rm_peso) {
		this.rm_peso = rm_peso;
	}

	public String getRm_talla() {
		return rm_talla;
	}

	public void setRm_talla(String rm_talla) {
		this.rm_talla = rm_talla;
	}

	public String getRm_edad() {
		return rm_edad;
	}

	public void setRm_edad(String rm_edad) {
		this.rm_edad = rm_edad;
	}

	public String getRm_TA() {
		return rm_TA;
	}

	public void setRm_TA(String rm_TA) {
		this.rm_TA = rm_TA;
	}

	public String getRm_rx() {
		return rm_rx;
	}

	public void setRm_rx(String rm_rx) {
		this.rm_rx = rm_rx;
	}

	public List<RecetaMedica> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<RecetaMedica> recetas) {
		this.recetas = recetas;
	}

	public boolean guardarRecetas() {
		try {
			gl.guardarRecetaMedica(rm_peso, rm_talla, rm_edad, rm_TA, rm_rx);
			recetas = gl.listarRecetasMedicas();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public List<RecetaMedica> recuperarRecetas(){
		recetas = gl.listarRecetasMedicas();
		return recetas;
	}
	
	public void eliminar() {
		gl.eliminarRecetaMedica(rm_codigo);
	}
	
	public void update() {
		gl.actualizarRecetaMedica(rm_codigo, rm_peso, rm_talla, rm_edad, rm_TA, rm_rx);
	}
	
	public RecetaMedica getReceta(int codigo) {
		return gl.getReceta(codigo);
	}

	@Override
	public String toString() {
		return "GestionRecetaMedicaBean [rm_codigo=" + rm_codigo + ", rm_peso=" + rm_peso + ", rm_talla=" + rm_talla
				+ ", rm_edad=" + rm_edad + ", rm_TA=" + rm_TA + ", rm_rx=" + rm_rx + ", recetas=" + recetas + "]";
	}
	
}
