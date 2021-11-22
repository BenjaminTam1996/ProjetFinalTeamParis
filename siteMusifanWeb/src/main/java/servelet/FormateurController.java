package servelet;

import java.io.IOException;
import java.util.Arrays;
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
 * Servlet implementation class FormateurController
 */
@WebServlet("/FormateurController")
public class FormateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormateurController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		RequestDispatcher rd = null;
		DaoFormateur daoFormateur=DaoFormateurFactory.getInstance();
		if(q == null) {
			List<Formateur> list = daoFormateur.findAll();
			request.setAttribute("formateurs", list);
			if(list != null && !list.isEmpty()) {
				rd=request.getRequestDispatcher("/WEB-INF/pageFormateur.jsp");
			}
		}else if(q.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			daoFormateur.deleteByKey(id);
			List<Formateur> list = daoFormateur.findAll();
			request.setAttribute("formateurs", list);
			if(list != null && !list.isEmpty()) {
				rd=request.getRequestDispatcher("/WEB-INF/pageFormateur.jsp");
			}
		}else if(q.equals("modif")) {
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idmodif", id);
			Formateur formateur = daoFormateur.findByKey(id);
			request.setAttribute("formateurModif", formateur);
			String nom = formateur.getNom();
			String prenom = formateur.getPrenom();
			request.setAttribute("formateurNom", nom);
			request.setAttribute("formateurPrenom", prenom);
			rd=request.getRequestDispatcher("/WEB-INF/pageModifFormateur.jsp");
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
