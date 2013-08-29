import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/", "/setup", "/results", "/ask"})
public class QuickPollController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    HttpSession session = request.getSession();
		String command = request.getServletPath();
	    response.setContentType("text/html");
	    
	    if (command.equals("/setup")) {
		    getServletContext()
		    	.getRequestDispatcher("/WEB-INF/setup.jsp")
		    	.forward(request,  response);
	    } else if (command.equals("/results")) {
	    	QuickPollModel model = new QuickPollModel(getServletContext());
	    	session.setAttribute("model", model);
	    	getServletContext()
		    	.getRequestDispatcher("/WEB-INF/results.jsp")
		    	.forward(request,  response);
	    } else {
	    	QuickPollModel model = new QuickPollModel(getServletContext());
	    	session.setAttribute("model", model);
	    	getServletContext()
		    	.getRequestDispatcher("/WEB-INF/ask.jsp")
		    	.forward(request,  response);
	    }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String command = request.getServletPath();
		String path = request.getContextPath();
    	QuickPollModel model = new QuickPollModel(getServletContext());

		if (command.equals("/setup")) {
			String q = request.getParameter("question");
			model.setQuestion(q);
			response.sendRedirect(path + "/ask");
		} else if (command.equals("/ask")) {
			String vote = request.getParameter("vote");
			model.castVote(vote);
			response.sendRedirect(path + "/results");
		} else {
			response.sendRedirect(path + "/ask");
		}
		
	}
	
}
