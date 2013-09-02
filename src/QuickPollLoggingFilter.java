
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
@WebFilter("/*")
public class QuickPollLoggingFilter implements Filter {
  ServletContext context;
  int counter;

  public void init(FilterConfig c) throws ServletException {
    context = c.getServletContext();
  }

  public void destroy() {}

  public void doFilter(ServletRequest request, 
                       ServletResponse response, 
                       FilterChain chain) 
      throws IOException, ServletException {
    String uri = ((HttpServletRequest)request).getRequestURI();
    int n = ++counter;
    context.log("Starting processing request #"+n+" to ("+uri+")");
    long t1 = System.currentTimeMillis();
    chain.doFilter(request, response);
    long t2 = System.currentTimeMillis();
    context.log("Done processing request #"+n+" in "+(t2-t1)+" ms");
  }
}
