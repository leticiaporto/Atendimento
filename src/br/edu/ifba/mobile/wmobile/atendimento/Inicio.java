package br.edu.ifba.mobile.wmobile.atendimento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="inicio")
@SessionScoped //não criar uma nova instancia da classe menu  quando mudar de página
public class Inicio {
	private String usuario="";
	private String senha= "";
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}