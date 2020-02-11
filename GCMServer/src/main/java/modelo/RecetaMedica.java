package modelo;

import javax.persistence.*;

@Entity
@TableGenerator(
		name = "RecetaMedica", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "rm_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
)
public class RecetaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rm_codigo;
	private String rm_peso;
	private String rm_talla;
	private String rm_edad;
	private String rm_TA;
	private String rm_rx;
	
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
	@Override
	public String toString() {
		return "RecetaMedica :\n\n\n "+ "Peso del paciente = " + rm_peso +"\n"+ " Talla del paciente = "
				+ rm_talla + " \n Edad del paciente = " + rm_edad + "\n Duracion del Tratamiento=" + rm_TA + "\n\n Indicaciones =\n\n" + rm_rx + "]";
	}
}
