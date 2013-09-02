import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "Ask", value = {"/ask"})
public class QuickPollAsk extends HttpServlet {
  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response)
      throws IOException, ServletException {
	    ServletContext c = getServletContext();
	    request.setAttribute("question", (String)c.getAttribute("question"));
	    RequestDispatcher dispatcher = request.getRequestDispatcher("ask.jsp");
	    dispatcher.forward(request, response); 
  }
}
