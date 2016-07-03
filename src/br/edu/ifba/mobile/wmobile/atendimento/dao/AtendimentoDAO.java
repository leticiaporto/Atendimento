package br.edu.ifba.mobile.wmobile.atendimento.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;

import br.edu.ifba.mobile.wmobile.atendimento.factory.ConnectionFactory;
import br.edu.ifba.mobile.wmobile.atendimento.modelo.Atendimento;

@ManagedBean(name="dao")
public class AtendimentoDAO {

    private Connection connection;
 
    public AtendimentoDAO() {
    	//Chamada para inicir conexão com o Banco de Dados
        this.connection = new ConnectionFactory().getConnection();
        
    }
   
    //Inserção no Banco de Dados
    public void adiciona(Atendimento atendimento) {
        String sql = "INSERT INTO atendimento(nomeCliente,nomeTecnico,situacao) VALUES (?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendimento.getNomeCliente());
            stmt.setString(2, atendimento.getNomeTecnico());
            stmt.setString(3, atendimento.getSituacao());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    
    //Atualização do atendimento para atendido pelo código
	public void atualiza(int codigo) {
        String sql = "UPDATE atendimento SET situacao='Atendido' where codigo=" + codigo;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException i) {
            throw new RuntimeException(i);
        }
    }
	//Exclusão do atendimento pelo código
    public void exclui(int codigo) {
        String sql = "DELETE FROM atendimento WHERE codigo="+codigo;
        try {
        	PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException u) {
	    	throw new RuntimeException(u);
	    }
        
    }

    //Consulta aos atendimentos
    public ArrayList<Atendimento> getListaAtendimentos(){
    	String sql = "SELECT codigo, nomeCliente, nomeTecnico, situacao FROM atendimento ORDER BY nomeTecnico ";
        ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
        ResultSet rs;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                atendimentos.add(new Atendimento(rs.getInt("codigo"),rs.getString("nomeCliente"),rs.getString("nomeTecnico"),rs.getString("situacao")));
            }
        } catch (SQLException u) {
            new RuntimeException(u);
        }
        return atendimentos;
    }
   
    //Metodo para saber a quantidade de atendimentos no BD para gerar a lista em listagem.html
    public int getCount(){
    	int registros=0;
    	String sql = "SELECT COUNT(codigo) FROM atendimento";
        ResultSet rs;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	registros = rs.getInt("COUNT(codigo)");
            }
                    
        } catch (SQLException u) {
            new RuntimeException(u);
        }
        return registros;
    }
    
    
    
}

