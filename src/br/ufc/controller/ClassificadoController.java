package br.ufc.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.NoticiaDAOHib;
import br.ufc.dao.OfertaDAO;
import br.ufc.dao.UsuarioDAOHib;
import br.ufc.model.Classificado;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Oferta;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {

	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO clDAO;
	
	@Autowired
	@Qualifier(value="ofertaDAO")
	private OfertaDAO oDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAOHib uDAO;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(HttpSession session){
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.print(formatarDate.format(data));
		
		session.setAttribute("data_hoje", formatarDate.format(data));
		return "classificado/inserir_classificado_formulario";
	}
	
	
	@RequestMapping("/inserirClassifcado")
	public String inserirClassifcado(@Valid Classificado classificado, HttpServletRequest req,
							   BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "classificado/inserir_classificado_formulario";
		}
		
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUsuario")));
		classificado.setAutor(autor);
		
		this.clDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}
	
	@RequestMapping("/inserirOfertaClassifcado")
	public String inserirOfertaClassifcado(@Valid Oferta oferta,HttpServletRequest req,
							   BindingResult result){
		
		Classificado classificado = clDAO.recuperar((long) Integer.parseInt(req.getParameter("idClass")));
		
		if(req.getParameter("idUser")!= ""){
			Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUser")));
			
			oferta.setIdUsuario(autor);
			oDAO.inserir(oferta);
			if(classificado.getMelhorOferta()!=null){
				if(classificado.getMelhorOferta().getOferta() < oferta.getOferta()){
					classificado.setMelhorOferta(oferta);
				}
				
			}else{
				classificado.setMelhorOferta(oferta);
			}
			
			oferta.setIdClassificado(classificado);
			oDAO.alterar(oferta);
			clDAO.alterar(classificado);
			
		}
		//return "classificado/classificado_inserido_ok";
		return "redirect:listaClassificadoPorClassificado?id="+ classificado.getId();
		
		//return "comentario/inserir_comentario";
	}
	
	@RequestMapping("/inserirOfertaFormulario")
	public String inserirOfertaFormulario(Long id, Model model){
		model.addAttribute("idClassificado",id);
		return "classificado/inserir_oferta_formulario";
	}
	

	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
		List<Classificado> classificados = this.clDAO.listar();
		model.addAttribute("classificados", classificados);
		return "classificado/listar_classificado";
	}
	
	@RequestMapping("/listaClassificadoPorClassificado")
	public String listaClassificadoPorClassificado(Long id, Model model){
		//Noticia noticia = nDAO.recuperar(id);
		Classificado classificados = clDAO.recuperar(id);
		//List<Comentario> comentarios = cDAO.recuperarComentario(noticia);
		
		model.addAttribute("classificados", classificados);
		//model.addAttribute("comentarios", comentarios);
		
		return "pages/listar_classificado_por_classificado";
	}
	
	/*@RequestMapping("/inserirOferta")
	public String inserirComentario(@Valid Oferta oferta,HttpServletRequest req,
							   BindingResult result){
		
		
		Classificado classificado= clDAO.recuperar((long) Integer.parseInt(req.getParameter("idClass")));
		classificado.setMelhorOferta(oferta);
		
		System.out.println("MUAHAHAHAHAH " +req.getParameter("idUser"));
		if(req.getParameter("idUser")!= ""){
			Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUser")));
		
			//oferta.setAutor(autor);
			oferta.setIdUsuario(autor);
			this.oDAO.inserir(oferta);
		}
			return "redirect:listaClassificadoPorClassificado?id="+ classificado.getId();
		
	}
	*/
}
