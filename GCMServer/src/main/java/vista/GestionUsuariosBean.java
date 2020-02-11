package vista;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import modelo.Cita;
import modelo.HistoriaClinica;
import modelo.Usuario;
import negocio.GestionUsuariosLocal;

import javax.faces.component.UIInput;

@ManagedBean
public class GestionUsuariosBean {
	
	@Inject
	private GestionUsuariosLocal gl;
	
	private Usuario usuario = getUser();
	
	private String us_cedula;
	private String us_rol;
	private String us_nombres;
	private String us_apellidos;
	private String us_sexo;
	private Date us_fecha_nacimiento;
	private String us_correo;
	private String us_contrasena;
	
	private String us_md_area_especialidad;
	private String us_md_descripcion;
	
	private String us_pa_estado_civil;
	private String us_pa_nivel_estudio;
	private String us_pa_ocupacion;
	private String us_pa_etnia;
	private String us_pa_religion;
	private String us_pa_tipo_sangre;
	private String us_pa_identidad_sexual;
	private String us_pa_procedencia;
	
	private List<HistoriaClinica> historias_clinica;
	private List<Cita> citas;
	private List<Usuario> usuarios;
	
	public GestionUsuariosLocal getGl() {
		return gl;
	}

	public void setGl(GestionUsuariosLocal gl) {
		this.gl = gl;
	}

	public String getUs_cedula() {
		return us_cedula;
	}

	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}

	public String getUs_rol() {
		return us_rol;
	}

	public void setUs_rol(String us_rol) {
		this.us_rol = us_rol;
	}

	public String getUs_nombres() {
		return us_nombres;
	}

	public void setUs_nombres(String us_nombres) {
		this.us_nombres = us_nombres;
	}

	public String getUs_apellidos() {
		return us_apellidos;
	}

	public void setUs_apellidos(String us_apellidos) {
		this.us_apellidos = us_apellidos;
	}

	public String getUs_sexo() {
		return us_sexo;
	}

	public void setUs_sexo(String us_sexo) {
		this.us_sexo = us_sexo;
	}

	public Date getUs_fecha_nacimiento() {
		return us_fecha_nacimiento;
	}

	public void setUs_fecha_nacimiento(Date us_fecha_nacimiento) {
		this.us_fecha_nacimiento = us_fecha_nacimiento;
	}

	public String getUs_correo() {
		return us_correo;
	}

	public void setUs_correo(String us_correo) {
		this.us_correo = us_correo;
	}

	public String getUs_contrasena() {
		return us_contrasena;
	}

	public void setUs_contrasena(String us_contrasena) {
		this.us_contrasena = us_contrasena;
	}

	public String getUs_md_area_especialidad() {
		return us_md_area_especialidad;
	}

	public void setUs_md_area_especialidad(String us_md_area_especialidad) {
		this.us_md_area_especialidad = us_md_area_especialidad;
	}

	public String getUs_md_descripcion() {
		return us_md_descripcion;
	}

	public void setUs_md_descripcion(String us_md_descripcion) {
		this.us_md_descripcion = us_md_descripcion;
	}

	public String getUs_pa_estado_civil() {
		return us_pa_estado_civil;
	}

	public void setUs_pa_estado_civil(String us_pa_estado_civil) {
		this.us_pa_estado_civil = us_pa_estado_civil;
	}

	public String getUs_pa_nivel_estudio() {
		return us_pa_nivel_estudio;
	}

	public void setUs_pa_nivel_estudio(String us_pa_nivel_estudio) {
		this.us_pa_nivel_estudio = us_pa_nivel_estudio;
	}

	public String getUs_pa_ocupacion() {
		return us_pa_ocupacion;
	}

	public void setUs_pa_ocupacion(String us_pa_ocupacion) {
		this.us_pa_ocupacion = us_pa_ocupacion;
	}

	public String getUs_pa_etnia() {
		return us_pa_etnia;
	}

	public void setUs_pa_etnia(String us_pa_etnia) {
		this.us_pa_etnia = us_pa_etnia;
	}

	public String getUs_pa_religion() {
		return us_pa_religion;
	}

	public void setUs_pa_religion(String us_pa_religion) {
		this.us_pa_religion = us_pa_religion;
	}

	public String getUs_pa_tipo_sangre() {
		return us_pa_tipo_sangre;
	}

	public void setUs_pa_tipo_sangre(String us_pa_tipo_sangre) {
		this.us_pa_tipo_sangre = us_pa_tipo_sangre;
	}

	public String getUs_pa_identidad_sexual() {
		return us_pa_identidad_sexual;
	}

	public void setUs_pa_identidad_sexual(String us_pa_identidad_sexual) {
		this.us_pa_identidad_sexual = us_pa_identidad_sexual;
	}

	public String getUs_pa_procedencia() {
		return us_pa_procedencia;
	}

	public void setUs_pa_procedencia(String us_pa_procedencia) {
		this.us_pa_procedencia = us_pa_procedencia;
	}

	public List<HistoriaClinica> getHistorias_clinica() {
		return historias_clinica;
	}

	public void setHistorias_clinica(List<HistoriaClinica> historias_clinica) {
		this.historias_clinica = historias_clinica;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	public void sesion(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        System.out.println("prueba sesión " + session.getAttribute("user"));
        if (session.getAttribute("user") == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("../User/index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	public void validarCedula(FacesContext context, UIComponent comp, Object value) {
		System.out.println("inside validate method");
		String cedula = (String) value;
		boolean cedulaCorrecta = false;
		
		try {
			 
			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9,10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if ((suma % 10 == 0) && (suma % 10 == verificador))
						cedulaCorrecta = true;
					else if ((10 - (suma % 10)) == verificador)
						cedulaCorrecta = true;
					else
						cedulaCorrecta = false;
				} else 
					cedulaCorrecta = false;
			} else
				cedulaCorrecta = false;
			
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}
		
		if (!cedulaCorrecta) {
			((UIInput) comp).setValid(false);
			FacesMessage message = new FacesMessage(
					"Cédula ecuatoriana no válida");
			context.addMessage(comp.getClientId(context), message);
		}

	}

	public String guardarUsuariosPaciente() {
		String rol="pac";
		int registro=1;
		System.out.println(us_cedula + " " + us_nombres + " ");
		gl.guardarUsuarioPaciente( us_cedula, rol,registro,   us_nombres,   us_apellidos,  us_sexo,  us_fecha_nacimiento,
				 us_correo,  us_contrasena,  us_pa_estado_civil,  us_pa_nivel_estudio,  us_pa_ocupacion,  us_pa_etnia, 
				 us_pa_religion,  us_pa_tipo_sangre,  us_pa_identidad_sexual,  us_pa_procedencia);
		
		return "index";
	}
	
	public String guardarUsuariosMedicos() {
		String rol2="med";
		System.out.println(us_cedula + " " + us_nombres + " "+rol2);
		gl.guardarUsuarioMedico(us_cedula, rol2, us_nombres, us_apellidos, us_sexo, us_fecha_nacimiento,
				us_correo, us_contrasena, us_md_area_especialidad, us_md_descripcion);
		
		return "index";
	}
	
	public List<Usuario> recuperarUsuarios(){
		usuarios = gl.getUsuarios();
		return usuarios;
	}
	
	public String login() {
		try {
			usuario = gl.login(us_correo, us_contrasena);
			System.out.println(usuario);
			if(usuario.getUs_rol().equals("pac")) {
				FacesContext context = FacesContext.getCurrentInstance();
		        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		        session.setAttribute("user", usuario);
				return "/User/perfil";
			}else {
				FacesContext context = FacesContext.getCurrentInstance();
		        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		        session.setAttribute("user", usuario);
				return "/Medicos/indexCita";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("user", null);
        System.out.println("logout " + session.getAttribute("user"));
		return "/User/index";
	}
	
	public void recuperarUsuario(String us_cedula) {
		Usuario u = gl.recuperarUsuario(us_cedula);
		this.us_cedula = us_cedula;
		us_nombres = u.getUs_nombres();
		us_apellidos = u.getUs_apellidos();
		us_sexo = u.getUs_sexo();
		us_fecha_nacimiento = u.getUs_fecha_nacimiento();
		us_pa_procedencia = u.getUs_pa_procedencia();
		us_correo = u.getUs_correo();
		us_pa_estado_civil = u.getUs_pa_estado_civil();
		us_pa_nivel_estudio = u.getUs_pa_nivel_estudio();
		us_pa_ocupacion = u.getUs_pa_ocupacion();
		us_pa_etnia = u.getUs_pa_etnia();
		us_pa_religion = u.getUs_pa_religion();
		us_pa_identidad_sexual = u.getUs_pa_identidad_sexual();
		us_pa_tipo_sangre = u.getUs_pa_tipo_sangre();
		us_md_area_especialidad =  u.getUs_md_area_especialidad();
		us_md_descripcion = u.getUs_md_descripcion();
		
		System.out.println("load data " + u);
	}
	
	private Usuario getUser() {
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        return (Usuario) session.getAttribute("user");
	}
	
	public void recuperarUsuario() {
		if(us_cedula==null)
			return;
		try {
			Usuario u = gl.recuperarUsuario(us_cedula);
			us_nombres = u.getUs_nombres();
			us_apellidos = u.getUs_apellidos();
			us_sexo = u.getUs_sexo();
			us_fecha_nacimiento = u.getUs_fecha_nacimiento();
			us_pa_procedencia = u.getUs_pa_procedencia();
			us_correo = u.getUs_correo();
			us_pa_estado_civil = u.getUs_pa_estado_civil();
			us_pa_nivel_estudio = u.getUs_pa_nivel_estudio();
			us_pa_ocupacion = u.getUs_pa_ocupacion();
			us_pa_etnia = u.getUs_pa_etnia();
			us_pa_religion = u.getUs_pa_religion();
			us_pa_identidad_sexual = u.getUs_pa_identidad_sexual();
			us_pa_tipo_sangre = u.getUs_pa_tipo_sangre();
			us_md_area_especialidad =  u.getUs_md_area_especialidad();
			us_md_descripcion = u.getUs_md_descripcion();
			
			System.out.println("load data " + u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
	}

	public String actualizarDatos() {
		Usuario u = gl.recuperarUsuario(us_cedula);
		if (us_nombres != null)
			u.setUs_nombres(us_nombres);
		if (us_apellidos != null)
			u.setUs_apellidos(us_apellidos);
		if (us_sexo != null)
			u.setUs_sexo(us_sexo);
		if (us_fecha_nacimiento != null)
			u.setUs_fecha_nacimiento(us_fecha_nacimiento);
		u.setUs_pa_procedencia(us_pa_procedencia);
		if (us_correo != null)
			u.setUs_correo(us_correo);
		u.setUs_pa_estado_civil(us_pa_estado_civil);
		u.setUs_pa_nivel_estudio(us_pa_nivel_estudio);
		u.setUs_pa_ocupacion(us_pa_ocupacion);
		u.setUs_pa_etnia(us_pa_etnia);
		u.setUs_pa_religion(us_pa_religion);
		u.setUs_pa_identidad_sexual(us_pa_identidad_sexual);
		if (us_pa_tipo_sangre != null)
			u.setUs_pa_tipo_sangre(us_pa_tipo_sangre);
		if (us_md_area_especialidad != null)
			u.setUs_md_area_especialidad(us_md_area_especialidad);
		if (us_md_descripcion != null)
			u.setUs_md_descripcion(us_md_descripcion);
		System.out.println("actualizarDatos " + u);
		gl.actualizarDatos(u);
		return "listar-pacientes";
	}

	public String actualizarDatos2() {
		System.out.println("actualizar2 " + usuario);
		System.out.println("actualizar2 " + usuario.getUs_cedula());
		gl.actualizarDatos(usuario);
		return "perfil";
	}
	
}








