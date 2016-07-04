package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAOHib;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAOHib aDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	//leitors
	@RequestMapping("/inserirLeitorFormulario")
	public String inserirLeitorFormulario(Model model){
		return "usuario/inserir_leitor_formulario";
	}
	
	@RequestMapping("/inserirLeitor")
	public String inserirLeitor(@Valid Usuario usuario, HttpServletRequest req,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_papel";
		}
		
		List<Papel> p = new ArrayList<Papel>();
		
		//System.out.println("user ps " + usuario.getListaPapeis().get(0).getId());
		p.add(this.pDAO.recuperar(1l));
		//System.out.println("papel"+(p.get(0).getPapel()));
		usuario.setListaPapeis(p);
		
		this.aDAO.inserir(usuario);
		return "redirect:goToHome";
	}
	

	
	/* usuarios completo */
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(Model model){
		List<Papel> papeis = this.pDAO.listar();
		model.addAttribute("papeis", papeis);
		
		return "usuario/inserir_usuario_papel";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@Valid Usuario usuario, HttpServletRequest req,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_papel";
		}
		
		List<Papel> p = new ArrayList<Papel>();
		
		//System.out.println("user ps " + usuario.getListaPapeis().get(0).getId());
		p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
		//System.out.println("papel"+(p.get(0).getPapel()));
		usuario.setListaPapeis(p);
		
		this.aDAO.inserir(usuario);
		return "usuario/usuario_inserido_ok";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		
		List<Usuario> usuarios = this.aDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		return "usuario/listar_usuario";
	}	
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		this.aDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		List<Papel> papeis = this.pDAO.listar();
		model.addAttribute("papeis", papeis);
		Usuario usuario = this.aDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario, HttpServletRequest req){
		List<Papel> p = new ArrayList<Papel>();
		
		p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
		//System.out.println("papel"+(p.get(0).getPapel()));
		usuario.setListaPapeis(p);
		this.aDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
	
	

}
