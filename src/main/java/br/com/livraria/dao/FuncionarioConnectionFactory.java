package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FuncionarioConnectionFactory {
// Eu começo criando um usuário e uma senha padrão
	// Note que os dois são definidos como String, permitindo números e caracteres
	// Preciso perguntar pra que finalidade e como exatamente isso vai ser utilizado
	// Pelo que percebi o JDBC vai fazer uma conexão e utilizar esse USER e SENHA
	// Preciso perguntar se eu poderia mudar, mas daí dependendo da configuração do
	// banco de dados, acredito eu
	private static final String USER = "root";
	private static final String SENHA = "root";

	public static Connection conectar() {
		try {

			// Eu anotei anteriormente que isso pega a biblioteca de conexão ao banco de
			// dados
			// Preciso perguntar se isso acessa a pasta lib que nós colocamos umas
			// bibliotecas
			Class.forName("com.mysql.jdbc.Driver");

			// Anotei posteriormente que isso daqui é um CREATE DATABASE
			// Mas ele usa .getConnection, preciso perguntar se ele conecta a um bd
			// existente ou realmente cria
			// Esse daqui retorna a conexão pra poder usar em outros lugares
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", USER, SENHA);
			return conexao;

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}

}
