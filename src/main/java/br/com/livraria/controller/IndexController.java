package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.livraria.dao.ConnectionFactory;
import br.com.livraria.dao.LivroDao;
import br.com.livraria.model.Livro;

// Anotaçãp -> pré-configura alto
// Essa aqui define ele como um controller
@Controller
public class IndexController{
	@RequestMapping("/")
	public String inicio() {
		// Conectar ao banco de dados
		ConnectionFactory.conectar();
		// Redirecionar a rota home
		return "redirect:home";
	}
	
	@RequestMapping("/home")
	// String -> Retorno de uma página
	public String index(Model model) {
		//
		LivroDao dao = new LivroDao();
		
		// items="${livros}"
		model.addAttribute("livros", dao.listar());
		return "home"; // home.html
	}
	
	@RequestMapping("/form")
	public String form(Long idLivro, Model model) {
		
		LivroDao dao = new LivroDao();
		
		Livro l = new Livro();
		
		if(idLivro != null) {
			l = dao.buscar(idLivro);
		}
		
		model.addAttribute("livro", l);
		
		return "form"; // form.html
	}
	
	@RequestMapping("/livro")
	public String livro(Long idLivro, Model model) {
		LivroDao dao = new LivroDao();
		
		model.addAttribute("livro", dao.buscar(idLivro));
		return "livro";
	}
	@RequestMapping(value = "adicionarLivro", method = RequestMethod.POST)
	public String adicionarLivro(Livro livro) {
		LivroDao dao = new LivroDao();
		dao.inserir(livro);
		return "redirect:home";
	}
	
	@RequestMapping("deletarLivro")
	public String deletarLivro(Long idLivro) {
		LivroDao dao = new LivroDao();
		
		dao.excluir(idLivro);
		
		return "redirect:home";
	}
	
	/*
	 * Atualizar Livro || GET || POST || PUT || DELETE
	 * GET - Buscar informações
	 * POST - Criar informações
	 * PUT -  Atualizar informações
	 * DELETE - Deletar informações
	 */
	
	@RequestMapping(value = "atualizarLivro", method = RequestMethod.POST)
	public String atualizarLivro(Long idLivro, Livro l) {
		LivroDao dao = new LivroDao();
		
		dao.atualizar(l, idLivro);
		
		return "redirect:home";
	}
}
