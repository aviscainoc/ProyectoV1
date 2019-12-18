package vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;

import modelo.Usuario;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.*;

import negocio.GestionUsuariosRemote;

public class ListarUsuario extends JFrame {
	private JPanel cp;
	private JTextArea txtCodigo = new JTextArea();
	private JLabel lblCodigo;
	
	
	GestionUsuariosRemote gl;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					ListarUsuario frame = new ListarUsuario();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ListarUsuario() {
		inicializar();
	}
	
	private void inicializar() {
		try {
			this.conectarInstancias();
		}catch(Exception e) {
			System.out.println("No se ha conectado");
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,200,285,300);
		cp = new JPanel();
		setContentPane(cp);
		cp.setLayout(new FlowLayout());
		
		lblCodigo = new  JLabel("LISTAR USUARIOS");
		List<Usuario> users = gl.getUsuarios();
		
		
		cp.add(lblCodigo);
		listar();
		cp.add(txtCodigo);
		
		
	}
	
	public void listar() {
		txtCodigo.setText("");
		List<Usuario> usuarios = gl.getUsuarios();
		for (Usuario u: usuarios) {
			txtCodigo.append(u.toString()+"\n");
		}
	}

	

protected void ListarUsuario(){
	int codigo = Integer.parseInt(txtCodigo.getText());
	System.out.println(codigo);

	List<Usuario> users = gl.getUsuarios();
	
	JList listaNombres=new JList();
	DefaultListModel modelo = new DefaultListModel();
	modelo.addElement(users);
	listaNombres.setModel(modelo);
	cp.add(listaNombres);
}

public void conectarInstancias() throws Exception {
	try {
		final Hashtable <String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        System.out.println("lleha 4");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");  
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb");  
          
        final Context context = new InitialContext(jndiProperties);             
        final String lookupName = "ejb:/BibEJBserver/GestionUsuarios!negocio.GestionUsuariosRemote";
        this.gl = (GestionUsuariosRemote) context.lookup(lookupName);
        System.out.println("gl instaciado");
        System.out.println("Agregado Correctamente");
          
    } catch (Exception ex) {  
       System.out.println("catch instancia");
    	ex.printStackTrace();  
        throw ex;  
	}
}
}
