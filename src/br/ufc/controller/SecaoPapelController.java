package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAOHib;
import br.ufc.dao.PapelDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Papel;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class SecaoPapelController {

	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAOHib nDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	/* Papel */
	@RequestMapping("/inserirPapelFormulario")
	public String inserirPapelF(){
		return "secaopapel/inserir_papel_formulario";
	}
	
	@RequestMapping("/inserirPapel")
	public String inserirPapel(@Valid Papel papel, BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "secaopapel/inserir_papel_formulario";
		}
		
		this.pDAO.inserir(papel);
		return "secaopapel/papel_inserido";
	}
	
	
	/* Seção */
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secaopapel/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(@Valid Secao secao, BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "secaopapel/secao_inserida";
		}
		
		sDAO.inserir(secao);
		return "secaopapel/secao_inserida";	
	}
	
	@RequestMapping("/listarSecao")
	public String listarSecao(Model model){
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "secaopapel/listar_secoes";
	}	
	
	@RequestMapping("/listaNoticiaPorSecao")
	public String listaNoticiaPorSecao(Long id, Model model){
		Secao secao = sDAO.recuperar(id);
		//List<Noticia> noticias = this.nDAO.listar();
		//model.addAttribute("noticias", noticias);
		//Secao secao = this.sDAO.recuperar(id);
		model.addAttribute("noticias", secao.getNoticia());
		return "pages/lista_noticia_por_secao";
	}
	
	
	
}
