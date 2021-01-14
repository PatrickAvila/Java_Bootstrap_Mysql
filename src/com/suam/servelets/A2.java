package com.suam.servelets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.suam.BD;
//import com.suam.RequestDispatcher;
import com.suam.insert.*;
import com.suam.service.UsuarioService;

/**
 * Servlet implementation class A2
 */
@WebServlet("/A2")
public class A2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * String nome = request.getParameter("Nome"); String end =
		 * request.getParameter("Endereco"); String email =
		 * request.getParameter("Email"); int resultado =
		 * ((Integer.parseInt(request.getParameter("questao1")) +
		 * Integer.parseInt(request.getParameter("questao2")) +
		 * Integer.parseInt(request.getParameter("questao3"))
		 * +Integer.parseInt(request.getParameter("questao4")) +
		 * Integer.parseInt(request.getParameter("questao5")))/3);
		 * response.setContentType("text/html"); PrintWriter pw = response.getWriter();
		 * pw.println("<HTML>");
		 * pw.println("<TITTLE><h1>Questionário Covid-19(Resposta) \n</h1>");
		 * pw.println("<BODY>"); pw.println("<p>Nome: " +nome+"</p>");
		 * pw.println("<p>Email: "+end+"</p>");
		 * pw.println("<p>Endereco: "+email+"</p>");
		 * pw.println("<p>Probabilidade de estar com Covid-19: "+resultado+"%</p>");
		 * pw.println("<a href=index.html> VOLTAR </a>"); pw.println("</HTML>");
		 * pw.println("</BODY>"); pw.flush();
		 */
		
		Connection conexao = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
		
		conexao = BD.getConnection();
//		System.out.println(conexao);
	
		
//		String nome = request.getParameter("Nome"); 
//		String end = request.getParameter("Endereco"); 
//		String email =request.getParameter("Email"); 
//		int resultado =((Integer.parseInt(request.getParameter("questao1")) + Integer.parseInt(request.getParameter("questao2")) 
//		+ Integer.parseInt(request.getParameter("questao3"))
//		+ Integer.parseInt(request.getParameter("questao4")) 
//		+ Integer.parseInt(request.getParameter("questao5")))/3);
//		

		
		//IncluirBanco banco = new IncluirBanco(String nome,String end,String email, int resultado);
		
		try {
			Contato contato = new Contato();
			String nome = request.getParameter("Nome"); 
			String end = request.getParameter("Endereco"); 
			String email = request.getParameter("Email"); 
			int resultado =((Integer.parseInt(request.getParameter("questao1")) + Integer.parseInt(request.getParameter("questao2")) 
			+ Integer.parseInt(request.getParameter("questao3"))
			+ Integer.parseInt(request.getParameter("questao4")) 
			+ Integer.parseInt(request.getParameter("questao5")))/3);
			request.setAttribute("nome",nome);
			request.setAttribute("Endereco",end);
			request.setAttribute("Email",email);
			request.setAttribute("Resultado",resultado);
			contato.setNome(nome);
			contato.setEndereco(end);
			contato.setResultado(resultado);
			UsuarioService.inserir(contato);

			request.getRequestDispatcher("A2.jsp").forward(request, response);
		
		} catch (Exception e) {
			// TODO: handle exception
			request.getRequestDispatcher("A2.jsp").forward(request, response);
		}
		
		
		

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
