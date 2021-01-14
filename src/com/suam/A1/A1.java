package com.suam.A1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A1
 */
@WebServlet("/A1")
public class A1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("Nome");
		String end = request.getParameter("Endereco");
		String email = request.getParameter("Email");
		int resultado =  ((Integer.parseInt(request.getParameter("questao1")) + Integer.parseInt(request.getParameter("questao2")) + Integer.parseInt(request.getParameter("questao3"))
		+Integer.parseInt(request.getParameter("questao4")) + Integer.parseInt(request.getParameter("questao5")))/3);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<HTML>");
		pw.println("<TITTLE><h1>Questionário Covid-19(Resposta) \n</h1>");
		pw.println("<BODY>");
			pw.println("<p>Nome: " +nome+"</p>");
			pw.println("<p>Email: "+end+"</p>");
			pw.println("<p>Endereco: "+email+"</p>");
			pw.println("<p>Probabilidade de estar com Covid-19: "+resultado+"%</p>");
			pw.println("<a href=index.html> VOLTAR </a>");
		pw.println("</HTML>");	
		pw.println("</BODY>");
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
