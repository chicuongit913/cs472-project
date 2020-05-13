package filters;

import models.UserModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName = "GateWayFilter")
public class GateWayFilter implements Filter {

    public GateWayFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletName = req.getServletPath().substring(1);

        //active menu by servlet name
        request.setAttribute("servletName", servletName);

        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/auth/login";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest || !this.isServletRequest(req)) {
            if(loggedIn) {
                UserModel user =  (UserModel) session.getAttribute("user");
                request.setAttribute("user", user);
            }
            final WrapperRequest wrappedRequest = new WrapperRequest(request);
            chain.doFilter(wrappedRequest, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private boolean isServletRequest(HttpServletRequest request) {
        String servletPath = request.getServletPath();

        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;

        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
}
