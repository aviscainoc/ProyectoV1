package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.*;

@Remote
public interface GestionRecetaMedicaRemote {
	public int guardarRecetaMedica(String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) ;
	public List<RecetaMedica> listarRecetasMedicas();
	public void actualizarRecetaMedica(int rm_codigo, String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) ;
	public void eliminarRecetaMedica(int rm_codigo);
	public RecetaMedica getReceta(int codigo);
}
