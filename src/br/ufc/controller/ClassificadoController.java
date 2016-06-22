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
import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.dao.OfertaDAO;
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
	private IUsuarioDAO uDAO;
	
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
		//JOptionPane.showMessageDialog(null, "ENTROU!!!");
		if(result.hasFieldErrors("nome")){
			return "classificado/inserir_classificado_formulario";
		}
		
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUsuario")));
		//System.out.println(autor.getId()+autor.getNome());
		classificado.setAutor(autor);
		//classificado.setMelhorOferta(0.0);
		
		this.clDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}
	
	/*@RequestMapping("/inserirOfertaClassifcado")
	public String inserirOfertaClassifcado(@Valid Oferta oferta, HttpServletRequest req,
							   BindingResult result){
		//JOptionPane.showMessageDialog(null, "ENTROU!!!");
		//if(result.hasFieldErrors("nome")){
			//return "classificado/inserir_classificado_formulario";
		//}
		
		Usuario autor = uDAO.recuperar((long) Integer.parseInt(req.getParameter("idUsuario")));
		//System.out.println(autor.getId()+autor.getNome());
		oferta.setIdUsuario(autor);
		//classificado.setMelhorOferta(0.0);
		
		this.clDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}
	*/
	@RequestMapping("/inserirOfertaClassifcado")
	public String inserirOfertaClassifcado(@Valid Oferta oferta,HttpServletRequest req,
							   BindingResult result){
		
		
		Classificado classificado = clDAO.recuperar((long) Integer.parseInt(req.getParameter("idClassi")));
		//comentario.setNoticia(noticia);
		//classificado.setMelhorOferta(oferta);
		//JOptionPane.showMessageDialog(null, "id noticia: "+comentario.getNoticia().getTitulo());
		//System.out.println("MUAHAHAHAHAH " +req.getParameter("idUsuario"));
		if(req.getParameter("idUser")!= ""){
			//Noticia noticia = nDAO.recuperar((long) Integer.parseInt(req.getParameter("idNoticia")));
			//comentario.setNoticia(noticia);
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
		return "classificado/classificado_inserido_ok";
		
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
	
	
}
