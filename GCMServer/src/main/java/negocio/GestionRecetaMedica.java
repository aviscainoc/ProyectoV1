package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.RecetaMedicaDAO;
import modelo.Cita;
import modelo.RecetaMedica;

@Stateless
public class GestionRecetaMedica implements GestionRecetaMedicaLocal, GestionRecetaMedicaRemote {
	
	@Inject
	private RecetaMedicaDAO dao;
	
	@Inject
	private CitaDAO daoC;
	
	@Override
	public int guardarRecetaMedica(String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) {
		RecetaMedica rm = new RecetaMedica();
		rm.setRm_peso(rm_peso);
		rm.setRm_talla(rm_talla);
		rm.setRm_edad(rm_edad);
		rm.setRm_TA(rm_TA);
		rm.setRm_rx(rm_rx);
		dao.insert(rm);
		System.out.println(rm);
		return rm.getRm_codigo();
	}

	@Override
	public List<RecetaMedica> listarRecetasMedicas() {
		return dao.getRecetasMedicas();
	}

	@Override
	public void actualizarRecetaMedica(int rm_codigo, String rm_peso, String rm_talla, String rm_edad, String rm_TA, String rm_rx) {
		
		RecetaMedica rm = new RecetaMedica();
		rm.setRm_codigo(rm_codigo);
		rm.setRm_peso(rm_peso);
		rm.setRm_talla(rm_talla);
		rm.setRm_edad(rm_edad);
		rm.setRm_TA(rm_TA);
		rm.setRm_rx(rm_rx);
		dao.update(rm);
		
	}

	@Override
	public void eliminarRecetaMedica(int rm_codigo) {
		// TODO Auto-generated method stub
		dao.remove(rm_codigo);
	}
	
	public RecetaMedica getReceta(int codigo) {
		return dao.read(codigo);
	}
	
	public int obtenerCodigoRM(int codigo) {
		System.out.println(daoC.obtenerCodigoReceta(codigo));
		return daoC.obtenerCodigoReceta(codigo);
	}
	
	public String obtenerTextoRM(int codigoCA) {
		String texto = dao.obtenerTextoRM(codigoCA);
		return texto;
	}

}
