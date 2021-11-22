package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/WEB-INF/loginPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("id");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/WEB-INF/loginPage.jsp");
		HttpSession session = request.getSession();
		
		if(login != null && password != null) {
			if(login.equals("admin") && password.equalsIgnoreCase("admin")) {
				rd=request.getRequestDispatcher("/admin/page1");
				session.setAttribute("login", login);
				session.setAttribute("type", "admin");
			}else if (login.equals("user") && password.equalsIgnoreCase("user")) {
				rd=request.getRequestDispatcher("/secure/page1");
				session.setAttribute("login", login);
				session.setAttribute("type", "user");
			}else {
				request.setAttribute("auth",true);
			}
		}else {
			request.setAttribute("isNull",true);
		}
		rd.forward(request, response);
	}

}
