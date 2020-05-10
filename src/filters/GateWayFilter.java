package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "GateWayFilter")
public class GateWayFilter implements Filter {

    public GateWayFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String servletName = req.getServletPath().substring(1);

        //active menu by servlet name
        request.setAttribute("servletName", servletName);

        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
