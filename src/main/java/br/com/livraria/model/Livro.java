package br.com.livraria.model;

public class Livro {
	private Long id;
	private double preco;
	private String nome;
	private String descricao;
	private String autor;
	private int qntdPaginas;
	
	
	public int getQntdPaginas() {
		return qntdPaginas;
	}
	public void setQntdPaginas(int qntdPaginas) {
		this.qntdPaginas = qntdPaginas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
}
