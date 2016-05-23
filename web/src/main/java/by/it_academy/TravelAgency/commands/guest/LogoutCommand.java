package by.it_academy.TravelAgency.commands.guest;

import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.getSession().invalidate();
        return page;
    }
}
