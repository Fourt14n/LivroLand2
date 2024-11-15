package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.livraria.model.Funcionario;
import br.com.livraria.model.Livro;

public class FuncionarioDao {
	private Connection conexao;
	// Eu anotei anteriormente que esse construtor é criado para facilitar a conexão com o banco
	public FuncionarioDao() {
		conexao = FuncionarioConnectionFactory.conectar();
	}
	
	public void inserir(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios(nome, cargo, idade) VALUES (?,?,?)";
		
		PreparedStatement smtp; // Executa a consulta sql
		// 
		try {
			
			smtp = conexao.prepareStatement(sql); // Preparar a consulta
			
			smtp.setString(1, funcionario.getNome());
			smtp.setString(2, funcionario.getCargo());
			smtp.setDouble(3, funcionario.getIdade());
			
			
			smtp.execute(); // Executa
			smtp.close(); // Fecha a consulta
			conexao.close(); // Fecha a conexão para impedir várias conexões 
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu erro no inserir do dao: " + e.getMessage());
		}
	}
}
