package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JBcandidato;
import model.JBvaga;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JBvaga vaga = new JBvaga();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		// teste de conexao DAO
		// dao.TesteConexao();

		// teste do controller: print /main por exemplo
		String action = request.getServletPath();
		if (action.equals("/main")) {
			response.sendRedirect("vagas.jsp");
		}
		if (action.equals("/insert")) {
			novaVaga(request, response);
		}

	}
	
	protected void novaVaga(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pegar parametros do form
		System.out.println(request.getParameter("data"));
		System.out.println(request.getParameter("descricao"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("salario"));	
		
		//setar variaveis javabeans
		vaga.setData("data");
		vaga.setDescricao("descricao");
		vaga.setNome("nome");
		vaga.setSalario("salario");
		
		//invocar o metodo contato passand o objeto contato
		dao.inserirVaga(vaga);
		
		response.sendRedirect("main");
	
		
		
	}


}
