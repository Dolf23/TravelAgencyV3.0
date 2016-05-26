package by.it_academy.TravelAgency.filters;

import by.it_academy.TravelAgency.commands.factory.CommandType;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dto.User;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Parameters.USER);
        if (user != null)
            filterChain.doFilter(request, response);
        else {
            CommandType commandType = getCommandType(request.getParameter(Parameters.COMMAND));
            if (commandType == CommandType.LOGIN || commandType == CommandType.GO_TO_REGISTRATION || commandType == CommandType.REGISTRATION || commandType == CommandType.BACK)
                filterChain.doFilter(request, response);
            else {
                String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.INSTANCE.getProperty(MessageConstants.LOGIN));
                RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    private CommandType getCommandType(String command) {
        CommandType commandType = CommandType.LOGIN;
        commandType = CommandType.valueOf(command.toUpperCase());
        return commandType;
    }
}
