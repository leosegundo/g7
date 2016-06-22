package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorGeral extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		//dica:
			//Criar uma lista de permitidos ou de bloqueador para nao cadastrados
			//percorre a lista e pronto
		String URI = request.getRequestURI();
		if(URI.endsWith("loginFormulario") ||
				   URI.endsWith("login") ||
				   URI.endsWith("irJornal")||
				   URI.endsWith("goToHome") ||
					URI.endsWith("logoutLeitor")){
			
				return true;
		}
		 
		
		if(request.getSession().getAttribute("redator_logado")!=null || request.getSession().getAttribute("jornalista_logado")!=null){
			return true;
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}
}