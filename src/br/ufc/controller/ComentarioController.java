package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAOHib;
import br.ufc.dao.UsuarioDAOHib;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@org.springframework.transaction.annotation.Transactional
@Controller
public class ComentarioController {

	@Autowired
	@Qualifier(value="comentarioDAO")
	ComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	UsuarioDAOHib uDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	NoticiaDAOHib nDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(Long id, Model model){
		model.addAttribute("idNoticia", id);
		return "comentario/inserir_comentario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(@Valid Comentario comentario,HttpServletRequest req,
							   BindingResult result){
		
		
		Noticia noticia = nDAO.recuperar((long) Integer.parseInt(req.getParameter("idNoticia")));
		comentario.setNoticia(noticia);
		
		System.out.println("MUAHAHAHAHAH " +req.getParameter("idUsuario"));
		if(req.getParameter("idUsuario")!= ""){
			Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUsuario")));
		
			comentario.setAutor(autor);
			this.cDAO.inserir(comentario);
		}
			return "redirect:listaNoticiaPorNoticia?id="+ noticia.getNoticiaId();
		
	}
	
	@RequestMapping("/listarComentarios")
	public String listarComentarios(Model model){
		List<Comentario> comentarios = this.cDAO.listar();
		model.addAttribute("comentarios", comentarios);
		return "comentario/listar_comentario";
	}	
}
