package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USER = "root";
	
	private static final String SENHA = "root";
	
	public static Connection conectar() {
		try {
			// Pegando a biblioteca de conexão ao banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			// CREATE DATABASE livraria;
			Connection conexao = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", USER, SENHA);
			return conexao;
			
		} catch (Exception e) {
			// throw -> jogar para cima
			// RuntimeException -> Erro que aconteceu enquanto o codigo rodava
			throw new RuntimeException();
		}
		
	}
}
