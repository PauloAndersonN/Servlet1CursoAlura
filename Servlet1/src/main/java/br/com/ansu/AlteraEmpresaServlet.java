package br.com.ansu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String paramId = request.getParameter("id");
			String paramData = request.getParameter("data");
			String paramNome = request.getParameter("nome");
			
			Integer id = Integer.valueOf(paramId);
			
			Date dataAbertura = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataAbertura = sdf.parse(paramData);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		
			Banco banco = new Banco();
			Empresa empresa = banco.buscaPorId(id);
			
			empresa.setNome(paramNome);
			empresa.setDataAbertura(dataAbertura);
		
			response.sendRedirect("listaEmpresas");
	}

}
