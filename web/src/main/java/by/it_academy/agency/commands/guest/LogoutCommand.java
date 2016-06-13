package by.it_academy.agency.commands.guest;

import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.getSession().invalidate();
        return page;
    }
}
