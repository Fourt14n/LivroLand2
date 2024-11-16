package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.Funcionario;

public class FuncionarioDao {
	private Connection conexao;
	// Eu anotei anteriormente que esse construtor é criado para facilitar a conexão com o banco
	public FuncionarioDao() {
		conexao = ConnectionFactory.conectar();
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
	
	public List<Funcionario> listar(){
		String sql = "SELECT * FROM funcionarios";
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			
			ResultSet resultado = smtp.executeQuery();
			while(resultado.next()) {
				Funcionario f = new Funcionario();
				f.setId(resultado.getLong("id"));
				f.setNome(resultado.getString("nome"));
				f.setCargo(resultado.getString("cargo"));
				f.setIdade(resultado.getInt("idade"));
				
				funcionarios.add(f);
			}
			
			resultado.close();
			smtp.close();
			conexao.close();
			return funcionarios;
			
			
		}catch (Exception e) {
			System.out.println("Deu erro no listar do dao: " + e.getMessage());
			System.out.println(e);
			throw new RuntimeException();
			// TODO: handle exception
		}
	}
	
	public Funcionario buscar(Long id) {
		String sql = "SELECT * FROM funcionarios WHERE id = ?";
		
		PreparedStatement smtp;
		
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Funcionario f = null;
			
			while(resultado.next()) {
				f.setId(resultado.getLong("id"));
				f.setNome(resultado.getString("nome"));
				f.setCargo(resultado.getString("cargo"));
				f.setIdade(resultado.getInt("idade"));
			}
			
			smtp.close();
			conexao.close();
			resultado.close();
			return f;
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no buscar do dao: " + e.getMessage());
			System.out.println(e);
			throw new RuntimeException();
			// TODO: handle exception
		}
		
		
	}
}
