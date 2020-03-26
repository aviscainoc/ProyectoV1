package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@TableGenerator(
		name = "Registro", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "re_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
)
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int re_codigo;
	
	
	private String re_titulo;
	
//	@Temporal(TemporalType.TIMESTAMP) 
	private String re_fecha;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="re_codigo")
	private List<Candidato> candidatos;

	public int getRe_codigo() {
		return re_codigo;
	}

	public void setRe_codigo(int re_codigo) {
		this.re_codigo = re_codigo;
	}

	public String getRe_titulo() {
		return re_titulo;
	}

	public void setRe_titulo(String re_titulo) {
		this.re_titulo = re_titulo;
	}

	public String getRe_fecha() {
		return re_fecha;
	}

	public void setRe_fecha(String re_fecha) {
		this.re_fecha = re_fecha;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	public void addCandidato(Candidato candidato) {
		if(candidatos==null)
			candidatos = new ArrayList<Candidato>();
		candidatos.add(candidato);
	}

	@Override
	public String toString() {
		return "Registro [re_codigo=" + re_codigo + ", re_titulo=" + re_titulo + ", re_fecha=" + re_fecha
				+ ", candidatos=" + candidatos + "]";
	}
	
	
	
	
}