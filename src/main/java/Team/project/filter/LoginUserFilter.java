package Team.project.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/app/*")
public class LoginUserFilter implements Filter {
  private String contextPath;

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub
    // 웹페이지의 root페이지의 url를 취득한다.
    contextPath = filterConfig.getServletContext().getContextPath();
  }


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    if (req.getSession().getAttribute("loginUser") != null) {
      chain.doFilter(req, res);
      return;
    }
    String path = req.getRequestURI();
<<<<<<< HEAD
    if (path.contains("/auth") || path.contains("/user/form") || path.contains("/user/add")) {
=======
    if (path.contains("/auth")) {
>>>>>>> upstream/master
      chain.doFilter(req, res);
      return;
    }
    res.setStatus(403);
    res.sendRedirect(contextPath + "/app/auth/form");
  }
}
