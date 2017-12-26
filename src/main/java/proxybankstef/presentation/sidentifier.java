package proxybankstef.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class sidentifier
 */
@WebServlet("/sidentifier")
public class sidentifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sidentifier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selogger = request.getParameter("utilisateur");
		String motDePasse = request.getParameter("motdepasse");

		if (selogger.equals("darennne") && motDePasse.equals("proxy")) {

			/*
			 * HttpSession session = request.getSession(); session.setAttribute(selogger,
			 * motDePasse);
			 */
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ecran2ListeClient.jsp");
			requestDispatcher.forward(request, response);

		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ecran1Page-dacceuil.jsp");
			requestDispatcher.forward(request, response);

		}

	}

}
