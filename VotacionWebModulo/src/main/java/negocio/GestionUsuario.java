package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CandidatoDAO;
import datos.VotoDAO;
import modelo.Candidato;
import modelo.Voto;

@Stateless
public class GestionUsuario implements GestionUsuariosLocal, GestionUsuariosRemote {
	
	@Inject 
	private CandidatoDAO daoU;
	@Inject 
	private VotoDAO daoV;
	
	
	public void agregarVoto(String nom_votante,String ced_votante, String ced_candidato) {
		
		Candidato ca = daoU.read(ced_candidato);
		Voto v = new Voto();
		v.setCed_votante(ced_votante);
		v.setNom_votante(nom_votante);
		daoV.insert(v);
		ca.addVoto(v);
		daoU.update(ca);
	}
	
	
	public List<Candidato> getUsuarios(){
		return daoU.getCandidatos();
	}
	
	
	
	
	
	
	
}



