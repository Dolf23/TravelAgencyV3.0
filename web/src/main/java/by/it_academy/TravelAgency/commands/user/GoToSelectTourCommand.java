package by.it_academy.TravelAgency.commands.user;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToSelectTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SELECT_TOUR_PAGE_PATH);
        return page;
    }
}
