package br.edu.ifba.mobile.wmobile.atendimento.factory;

import java.sql.Connection; //conexao sql para Java
import java.sql.DriverManager; // driver de conexão sql para Java
import java.sql.SQLException; // classes para tratamendo de excessões

public class ConnectionFactory {
//Classe de conexao com o Banco de Dados
	public Connection getConnection(){
    	try {
            Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    	}
    	try {
    		return DriverManager.getConnection("jdbc:mysql://localhost/agendaatendimento", "root", "");
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		throw new RuntimeException(e);
    	}
    }
}  
