package servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.DaoFormateur;
import jdbc.dao.DaoFormateurFactory;
import jdbc.model.Formateur;

/**
 * Servlet implementation class modifFormateurServlet
 */
@WebServlet("/modifFormateurServlet")
public class modifFormateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifFormateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		DaoFormateur daoFormateur=DaoFormateurFactory.getInstance();
		
		int idmodif=Integer.parseInt(request.getParameter("id"));		

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		if(prenom != null && !prenom.isEmpty() && nom != null && !nom.isEmpty()) {
			rd=request.getRequestDispatcher("/WEB-INF/pageFormateur.jsp");
			Formateur modifFormateur = new Formateur(idmodif,prenom,nom);
			daoFormateur.update(modifFormateur);

			List<Formateur> list = daoFormateur.findAll();
			request.setAttribute("formateurs", list);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
