package by.it_academy.TravelAgency.commands.user;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToMainUserCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_PAGE_PATH);
        return page;
    }
}
