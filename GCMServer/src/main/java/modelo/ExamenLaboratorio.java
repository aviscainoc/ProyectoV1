package modelo;

import javax.persistence.*;

@Entity
@TableGenerator(
		name = "ExamenLaboratorio", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "el_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
)
public class ExamenLaboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int el_codigo;
	private String el_quimica;
	private String el_heces;
	private String el_microbiologia;
	private String el_hematologia;
	private String el_orina;
	public int getEl_codigo() {
		return el_codigo;
	}
	public void setEl_codigo(int el_codigo) {
		this.el_codigo = el_codigo;
	}
	public String getEl_quimica() {
		return el_quimica;
	}
	public void setEl_quimica(String el_quimica) {
		this.el_quimica = el_quimica;
	}
	public String getEl_heces() {
		return el_heces;
	}
	public void setEl_heces(String el_heces) {
		this.el_heces = el_heces;
	}
	public String getEl_microbiologia() {
		return el_microbiologia;
	}
	public void setEl_microbiologia(String el_microbiologia) {
		this.el_microbiologia = el_microbiologia;
	}
	public String getEl_hematologia() {
		return el_hematologia;
	}
	public void setEl_hematologia(String el_hematologia) {
		this.el_hematologia = el_hematologia;
	}
	public String getEl_orina() {
		return el_orina;
	}
	public void setEl_orina(String el_orina) {
		this.el_orina = el_orina;
	}
	@Override
	public String toString() {
		return "ExamenLaboratorio \n\n\n "
				+ "Examenes Quimicos = " + el_quimica
				+ "\nExamenes de Heces = " + el_heces 
				+ "\nMicrobiologia = " + el_microbiologia 
				+ "Ematologia = "+ el_hematologia 
				+ "Orina = " + el_orina + "]";
	}	
}
