package servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoDataServlet
 */
@WebServlet("/DemoDataServlet")
public class DemoDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//on a déjà une seesion
		//on a pas de session
		session.setAttribute("session1", "un message en session");
		session.setAttribute("sessionid", session.getId());
		//session.invalidate();
		//session.getMaxInactiveInterval();
		
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("application1", "un message en application");
	
		session.setAttribute("List",new ArrayList<String>());
		((ArrayList<String>)session.getAttribute("List")).add("aaa");
		
		
		Cookie cookie = new Cookie("cookie1","message du cookie1");
		//si cookie ne précise pas de temps, il est stocké dans le compte utilisateur
		cookie.setMaxAge(3600*24*7);
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
