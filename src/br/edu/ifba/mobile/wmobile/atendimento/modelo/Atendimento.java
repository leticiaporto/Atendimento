package br.edu.ifba.mobile.wmobile.atendimento.modelo;

import javax.faces.bean.ManagedBean;
import br.edu.ifba.mobile.wmobile.atendimento.dao.AtendimentoDAO;

@ManagedBean(name="atendimento")
public class Atendimento {
	int codigo;
	String situacao,nomeCliente,nomeTecnico;
	public Atendimento(){
		
	}
	
	public Atendimento(int codigo,String nomeCliente, String nomeTecnico, String situacao){
		this.codigo = codigo;
		this.situacao = situacao;
		this.nomeCliente = nomeCliente;
		this.nomeTecnico = nomeTecnico;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getNomeTecnico() {
		return nomeTecnico;
	}
	
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	
	//Método para adicionar o objeto atual ao banco de dados
	public void setAtendimento(){
		Atendimento at=new Atendimento();
		at.setNomeCliente(this.nomeCliente);
		at.setNomeTecnico(this.nomeTecnico);
		at.setSituacao(this.situacao);
		AtendimentoDAO atd=new AtendimentoDAO();
		atd.adiciona(at);
	}
	
	@Override
	public String toString() {
		return "Téc." + nomeTecnico+"|"+nomeCliente+"|"+ situacao;
	}
	

}
