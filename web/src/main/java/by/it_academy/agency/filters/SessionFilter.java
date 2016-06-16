package by.it_academy.agency.filters;

import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session session = HibernateUtil.getSession();
        filterChain.doFilter(servletRequest, servletResponse);
        HibernateUtil.releaseSession(session);
    }

    @Override
    public void destroy() {

    }
}
