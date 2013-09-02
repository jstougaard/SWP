import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "Setup", value = {"/setup"})
public class QuickPollSetup extends HttpServlet {
  public void doPost(HttpServletRequest request, 
                     HttpServletResponse response)
      throws IOException, ServletException {
    String q = request.getParameter("question");
    ServletContext c = getServletContext();
    c.setAttribute("question", q);
    c.setAttribute("yes", new Integer(0));
    c.setAttribute("no", new Integer(0));
    request.setAttribute("Success","true");
    RequestDispatcher dispatcher = request.getRequestDispatcher("setup.jsp");
    dispatcher.forward(request, response); 
  }
  
  public void doGet(HttpServletRequest request, 
          HttpServletResponse response)
throws IOException, ServletException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("setup.jsp");
	  dispatcher.forward(request, response);
  }
}
