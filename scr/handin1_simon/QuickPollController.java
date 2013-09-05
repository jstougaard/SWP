package handin1_simon;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/", "/ask", "/setup", "/results", "/vote"})
public class QuickPollController extends HttpServlet{
	
	private QuickPollModel model;
	
	
		public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		String path = request.getServletPath();
	
		model = new QuickPollModel(getServletContext());
		
		//If path is /, go directly to question.jsp for the client to provide a question to be voted for
		if(path.equals("/")){
	    	RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
	        rd.forward(request, response);
		}
		
		//If path is /ask, send a model with a RequestDispatcher to ask.jsp
		else if(path.equals("/ask")){
			RequestDispatcher rd = request.getRequestDispatcher("ask.jsp");
			request.setAttribute("model", model);
			rd.forward(request, response);
				
		}
		else if(path.equals("/results")){

			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			request.setAttribute("model", model);
			rd.forward(request, response);
		}
	  
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String path = request.getServletPath(); 
//		QuickPollModel model = new QuickPollModel(getServletContext());
		
		//Setup question
		if(path.equals("/setup")){
			String question = request.getParameter("question");
			model.setQuestion(question);			
			RequestDispatcher rd = request.getRequestDispatcher("setup.jsp");
			request.setAttribute("model", model);
		    rd.forward(request, response);
			
		}
		
		if(path.equals("/vote")){
			String vote = request.getParameter("vote");
			model.setVote(vote);	
			RequestDispatcher rd = request.getRequestDispatcher("vote.jsp");
			request.setAttribute("model", model);
		    rd.forward(request, response);
			
		}
		
	}
	
	  
}
