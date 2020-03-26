package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.TableGenerator;


@Entity
@TableGenerator(
		name = "Voto", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "vo_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
)
public class Voto {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int re_codigo;
	
	private String ced_votante;
	private String nom_votante;
	public int getRe_codigo() {
		return re_codigo;
	}
	public void setRe_codigo(int re_codigo) {
		this.re_codigo = re_codigo;
	}
	public String getCed_votante() {
		return ced_votante;
	}
	public void setCed_votante(String ced_votante) {
		this.ced_votante = ced_votante;
	}
	public String getNom_votante() {
		return nom_votante;
	}
	public void setNom_votante(String nom_votante) {
		this.nom_votante = nom_votante;
	}
	@Override
	public String toString() {
		return "Voto [re_codigo=" + re_codigo + ", ced_votante=" + ced_votante + ", nom_votante=" + nom_votante + "]";
	}
}




