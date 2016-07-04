package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAOHib;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAOHib;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Papel;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class NoticiaController {
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAOHib nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAOHib uDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="comentarioDAO")
	private ComentarioDAO cDAO;
	
	@Autowired
	private ServletContext servletContext;

	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia, HttpServletRequest req,
							   BindingResult result, @RequestParam(value="imagem", required=false) MultipartFile imagem,
							   @RequestParam(value="video", required=false) MultipartFile video){
		if(result.hasFieldErrors("nome")){
			return "noticia/inserir_noticia_formulario";
		}
		
		Secao secao = sDAO.recuperar(req.getParameter("secaoValores"));
		noticia.setSecao(secao);
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("usuario")));
		noticia.setAutor(autor);
		this.nDAO.inserir(noticia);
		

		String path = servletContext.getRealPath("/")+"resources/images/"+noticia.getNoticiaId()+".png";
		AulaFileUtil.salvarImagem(path, imagem);
		
		
		return "noticia/noticia_inserido_ok";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model){
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/listaNoticiaPorNoticia")
	public String listaNoticiaPorNoticia(Long id, Model model){
		Noticia noticia = nDAO.recuperar(id);
		List<Comentario> comentarios = cDAO.recuperarComentario(noticia);
		
		model.addAttribute("secao", noticia.getSecao());
		model.addAttribute("noticias", noticia);
		model.addAttribute("comentarios", comentarios);
		
		return "pages/lista_noticia_por_noticia";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id){
		System.out.println("entrouuu "+ id);
		this.nDAO.apagar(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia, Long secaoValores, Long idAutor){
		noticia.setAutor(uDAO.recuperar(idAutor));
		noticia.setSecao(sDAO.recuperar(secaoValores));
		System.out.println("hahahahaha "+ noticia.getNoticiaId());
		nDAO.alterar(noticia);
		return "redirect:listaNoticiaPorNoticia?id="+noticia.getNoticiaId();
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model){
		Noticia noticia = nDAO.recuperar(id);
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes",secoes);
		model.addAttribute("noticia",noticia);
		
		return "noticia/alterar_noticia_formulario";
	}
	
	
	/*Linkamentos */
	@RequestMapping("/goToHome")
	public String goToHome(Model model){
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);
		return "pages/index";
	}
	
	
}
