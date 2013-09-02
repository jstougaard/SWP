import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "Results", value = {"/results"})
public class QuickPollResults extends HttpServlet {
  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response)
      throws IOException, ServletException {
    ServletContext c = getServletContext();
    request.setAttribute("total", (((Integer)c.getAttribute("yes")).intValue()+((Integer)c.getAttribute("no")).intValue()));
    request.setAttribute("yes", ((Integer)c.getAttribute("yes")).intValue());
    request.setAttribute("no", ((Integer)c.getAttribute("no")).intValue());
    request.setAttribute("question", (String)c.getAttribute("question"));
    RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
    dispatcher.forward(request, response); 

  }
}
