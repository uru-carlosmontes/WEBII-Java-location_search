package cams.org.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Content
 */
@WebServlet("/content")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String [][] users = {
    		{"0001", "Carlos Montes"},
    		{"0002", "Fulano de tal"},
    		{"0003", "Alguien Mas"},
    		{"0004", "Random Name"}
    };
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Content() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String res = "User not found";
		if (id == null) {
			res = "ID was not passed";
		} else {
			for (int i = 0; i < users.length; i++) {
				if (id.equals(users[i][0]))
					res = users[i][1];
			}
		}
		
		response.setContentType("application/json");
		response.getWriter().print("{\"user\": \""+res+"\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
