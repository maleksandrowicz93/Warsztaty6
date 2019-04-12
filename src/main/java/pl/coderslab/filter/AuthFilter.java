package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        if (!(req instanceof HttpServletRequest)){
//            chain.doFilter(req, resp);
//            return;
//        }
        HttpSession session = ((HttpServletRequest) req).getSession();
        Long userID = (Long) session.getAttribute("userID");
        if (userID == null) {
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_FORBIDDEN, "You are not authorized");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
