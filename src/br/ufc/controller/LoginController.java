package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IAlunoDAO;
import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAOHib;
import br.ufc.model.MD5Criptografia;
import br.ufc.model.Noticia;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="alunoDAO")
	private IAlunoDAO aDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAOHib uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private INoticiaDAO nDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session, Model model){
		/*prossegue */
		Usuario candidato = uDAO.recuperar(usuario.getLogin());
		MD5Criptografia md5 = new MD5Criptografia();
		//System.out.println("candidato " + candidato.getSenha());
		//System.out.println("usuer "+ usuario.getSenha());
		List<Papel> p = new ArrayList<Papel>();
        if(candidato!=null){
			if(candidato.getSenha().equals(usuario.getSenha())){
				//Papel aux = pDAO.recuperarPU(usuario.getId());
				Usuario aux = uDAO.recuperar(usuario.getLogin());
				//p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papel"))));
				//System.out.println("aux id " +aux.getListaPapeis().get(0).getId());
				if(aux.getListaPapeis().get(0).getId()== 1){
					session.setAttribute("usuario_logado", candidato);
					session.setAttribute("Tipo", aux.getId());
					return "redirect:goToHome";
				}
				else if(aux.getListaPapeis().get(0).getId() == 2){
					session.setAttribute("jornalista_logado", candidato);
				}
				else if(aux.getListaPapeis().get(0).getId() == 3){
					session.setAttribute("redator_logado", candidato);
				}
//				else{
//					session.setAttribute("Tipo", 0);
//					return "pages/index";
//				}
				//session.setAttribute("usuario_logado", candidato);
				session.setAttribute("Tipo", aux.getId());

				List<Noticia> noticias = this.nDAO.listar();
				model.addAttribute("noticias", noticias);
				
				
				return "menu";
				
			}
		}
		//return "redirect:loginFormulario";
        session.setAttribute("Tipo", 0);
        //return "pages/index";
        return "redirect:goToHome";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		//return "redirect:loginFormulario";
		return "redirect:goToHome";
	}
	
	@RequestMapping("/logoutLeitor")
	public String logoutLeitor(HttpSession session){
		session.invalidate();
		return "redirect:goToHome";
	}
}










