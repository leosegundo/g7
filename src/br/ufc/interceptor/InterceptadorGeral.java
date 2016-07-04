package br.ufc.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorGeral extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		//dica:
			//Criar uma lista de permitidos ou de bloqueador para nao cadastrados
			//percorre a lista e pronto
		List<String> permitidos = new ArrayList<String>();
		permitidos.add("/g2/loginFormulario");
		permitidos.add("/g2/login");
		permitidos.add("/g2/irJornal");
		permitidos.add("/g2/goToHome");
		permitidos.add("/g2/listarSecao");
		permitidos.add("/g2/listarClassificado");
		permitidos.add("/g2/inserirLeitorFormulario");
		permitidos.add("/g2/inserirLeitor");
		permitidos.add("/g2/logoutLeitor");
		permitidos.add("/g2/listaNoticiaPorNoticia");
		permitidos.add("/g2/listaNoticiaPorSecao");
		permitidos.add("/g2/listaClassificadoPorClassificado");
		permitidos.add("/g2/inserirComentario");
		
		
		String URI = request.getRequestURI();
		
		if(permitidos.contains(URI) || URI.contains("resources")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuario_logado")!=null ){
			if(URI.endsWith("inserirOfertaClassifcado")||
					URI.endsWith("inserirComentario")){
				
					return true;
			}
		}
		
		if(request.getSession().getAttribute("redator_logado")!=null ){
			if(URI.endsWith("menu")||
				URI.endsWith("inserirUsuarioFormulario") ||
				URI.endsWith("inserirUsuario") ||
				URI.endsWith("listarUsuario")||
				URI.endsWith("inserirSecaoFormulario") ||
				URI.endsWith("inserirSecao") ||
				URI.endsWith("inserirClassificadoFormulario") ||
				URI.endsWith("inserirClassifcado") ||
				URI.endsWith("inserirPapelFormulario") ||
				URI.endsWith("inserirPapel")||
				URI.endsWith("listarNoticia")){
				
					return true;
			}
		}
		
		if(request.getSession().getAttribute("jornalista_logado")!=null){
			if(URI.endsWith("menu")||
					URI.endsWith("inserirNoticiaFormulario") ||
					URI.endsWith("listarUsuario")||
					URI.endsWith("inserirNoticia") ||
					URI.endsWith("listarNoticia") ||
					URI.endsWith("alterarNoticia") ||
					URI.endsWith("inserirPapelFormulario") ||
					URI.endsWith("alterarNoticiaFormulario") ||
					URI.endsWith("inserirPapel") ||
					URI.endsWith("inserirUsuarioFormulario")){
					
						return true;
				}
		}
		
		if(request.getSession().getAttribute("adm_logado")!=null){
			if(URI.endsWith("menu")||
					URI.endsWith("inserirUsuarioFormulario") ||
					URI.endsWith("inserirUsuario") ||
					URI.endsWith("inserirPapelFormulario") ||
					URI.endsWith("inserirPapel")){
				return true;
			}
					
			
		}
		
		response.sendRedirect("goToHome");
		return false;
	}
}
