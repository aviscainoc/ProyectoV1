package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.RecetaMedica;

@Local
public interface GestionRecetaMedicaLocal {

	public int guardarRecetaMedica(String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) ;
	public List<RecetaMedica> listarRecetasMedicas();
	public void actualizarRecetaMedica(int rm_codigo, String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) ;
	public void eliminarRecetaMedica(int rm_codigo);
	public RecetaMedica getReceta(int codigo);
	public int obtenerCodigoRM(int codigo);
	public String obtenerTextoRM(int codigoCA);
}
