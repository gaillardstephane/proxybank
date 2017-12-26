package proxybankstef.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxybankstef.service.ServiceClient;

/**
 * Servlet implementation class , elle reçoit la requette émise par
 * le conseiller pour creer un client, la traite et l'execute, et renvoi vers la page adequate.
 */
@WebServlet("/ServletClientSup")
public class ServletCLientSup extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ServiceClient sc = new ServiceClient();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCLientSup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idClientsup = Integer.parseInt(request.getParameter("idClientsuprimer"));
		sc.removeClient(idClientsup);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ecran2ListeClient.jsp");
		requestDispatcher.forward(request, response);
	}

}
