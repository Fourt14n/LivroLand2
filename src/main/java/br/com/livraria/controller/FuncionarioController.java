package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.livraria.dao.FuncionarioDao;
import br.com.livraria.model.Funcionario;

@Controller
public class FuncionarioController {
	@RequestMapping("/funcionarios_home")
	public String funcionarios_home(Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		model.addAttribute("funcionarios", dao.listar());
		return "funcionarios_home";
	}
	
	@RequestMapping("/funcionarios_form")
	public String funcionarios_form(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario funcionario = new Funcionario();
		
		if(idFuncionario != null) {
			funcionario = dao.buscar(idFuncionario);
		}
		
		model.addAttribute("funcionario", funcionario);
		return "funcionarios_form";
		
	}
	
	@RequestMapping("/funcionario")
	public String funcionario(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		
		model.addAttribute("funcionario", dao.buscar(idFuncionario));
		
		return "funcionario";
	}
	
	@RequestMapping(value = "adicionarFuncionario", method = RequestMethod.POST)
	public String adicionarFuncionario(Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao();
		dao.inserir(funcionario);
		return "redirect:funcionarios_home";
	}
	
	@RequestMapping(value = "editarFuncionario", method = RequestMethod.POST)
	public String editarFuncionario(Long idFuncionario, Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao();
		
		dao.editar(idFuncionario, funcionario);
		
		
		return "redirect:funcionarios_home";
		
	}
		
	@RequestMapping(value = "deletarFuncionario", method = RequestMethod.GET)
	public String deletarFuncionario(Long idFuncionario) {
		FuncionarioDao dao = new FuncionarioDao();
		
		dao.deletar(idFuncionario);
		
		return "redirect:funcionarios_home";
	}
	
	
	
	
}
