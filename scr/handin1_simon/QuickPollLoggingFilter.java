package handin1_simon;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")

public class QuickPollLoggingFilter implements Filter {
  ServletContext context;
  int counter;
 

  public void init(FilterConfig c) throws ServletException {
    context = c.getServletContext();
    System.out.println("FILTER!");
  }

  public void destroy() {}

  public void doFilter(ServletRequest request, 
                       ServletResponse response, 
                       FilterChain chain) 
      throws IOException, ServletException {
    String uri = ((HttpServletRequest)request).getRequestURI();
    int n = ++counter;
    context.log("starting processing request #"+n+" ("+uri+")");
    long t1 = System.currentTimeMillis();
    chain.doFilter(request, response);
    long t2 = System.currentTimeMillis();
    context.log("done processing request #"+n+", "+(t2-t1)+" ms");
  }
}