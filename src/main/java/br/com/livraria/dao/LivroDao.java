package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.Livro;

public class LivroDao {
	private Connection conexao;
	
	// Sempre que eu instanciar, ele conectará ao banco
	public LivroDao(){
		conexao = ConnectionFactory.conectar();
		
	}
	
	public void inserir(Livro livro) {
		String sql = "INSERT INTO livros(nome, preco, descricao, autor, qntdPaginas) VALUES (?,?,?,?,?)";
		
		PreparedStatement smtp; // Executa a consulta sql
		// 
		try {
			
			smtp = conexao.prepareStatement(sql); // Preparar a consulta
			
			smtp.setString(1, livro.getNome());
			smtp.setDouble(2, livro.getPreco());
			smtp.setString(3, livro.getDescricao());
			smtp.setString(4, livro.getAutor());
			smtp.setInt(5, livro.getQntdPaginas());
			
			smtp.execute(); // Executa
			smtp.close(); // Fecha a consulta
			conexao.close(); // Fecha a conexão para impedir várias conexões 
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu erro: " + e.getMessage());
		}
	}
	
	public List<Livro> listar() {
		String sql = "SELECT * FROM livros";
		
		PreparedStatement smtp;
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			
			smtp = conexao.prepareStatement(sql);
			// Resultado = Lista de pizzas, pode ser vazia [] ou com objetos [{}]
			
			ResultSet resultado = smtp.executeQuery();
			while(resultado.next()) {
				Livro li = new Livro();
				// Aqui eu pego o nome da coluna
				li.setId(resultado.getLong("id"));
				li.setNome(resultado.getString("nome"));
				li.setPreco(resultado.getDouble("preco"));
				li.setDescricao(resultado.getString("descricao"));
				li.setQntdPaginas(resultado.getInt("qntdPaginas"));
				li.setAutor(resultado.getString("autor"));
				livros.add(li);
			}
			
			resultado.close();
			smtp.close();
			conexao.close();
			return livros;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erroo" + e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public Livro buscar(Long id) {
		String sql = "SELECT * FROM livros WHERE id = ?";
		
		PreparedStatement smtp;
		 
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Livro l = null; // Não instanciando
			
			while(resultado.next()) {
				l = new Livro();
				l.setId(resultado.getLong("id"));
				l.setNome(resultado.getString("nome"));
				l.setAutor(resultado.getString("autor"));
				l.setDescricao(resultado.getString("descricao"));
				l.setQntdPaginas(resultado.getInt("qntdPaginas"));
				l.setPreco(resultado.getDouble("preco"));
				
			}
			smtp.close();
			conexao.close();
			resultado.close();
			return l;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
			throw new RuntimeException();
		}
		
	}
	
	public void excluir(Long livroId) {
		String sql = "DELETE FROM livros WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			
			smtp = conexao.prepareStatement(sql);
			// Esse setLong pega o ? que vem da consulta do SQL, ele é one based, então começa do 1
			smtp.setLong(1, livroId);
			
			smtp.execute();
			
			
			smtp.close();
			conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Livro l, Long idLivro) {
		String sql = "UPDATE livros SET nome = ?, preco = ?, descricao = ?, autor = ?, qntdPaginas = ? WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			// 1. Nome
			// 2. Preco
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, l.getNome());			
			smtp.setDouble(2, l.getPreco());			
			smtp.setString(3, l.getDescricao());			
			smtp.setString(4, l.getAutor());			
			smtp.setInt(5, l.getQntdPaginas());	
			smtp.setLong(6, idLivro);
			
			smtp.execute();
			smtp.close();
			conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu erro no atualizar no dao: " + e.getMessage());
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}
}
