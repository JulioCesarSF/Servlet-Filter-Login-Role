package julio.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")
public class MeuFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)req).getRequestURI();
		
		String tipoUsuario = (String)((HttpServletRequest)req).getSession().getAttribute("tipoUsuario");
		
		if(uri.contains("Usuario") || uri.contains("TipoUsuario")){
			if(tipoUsuario == null || !tipoUsuario.equals("Admin")){
				//req.getRequestDispatcher(uri).forward(req, resp);
			}else{
				System.out.println(tipoUsuario);
			}
		}
		
		filter.doFilter(req, resp);
		
		
	}

}
