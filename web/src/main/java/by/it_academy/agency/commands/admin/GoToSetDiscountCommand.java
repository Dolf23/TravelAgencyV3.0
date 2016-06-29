package by.it_academy.agency.commands.admin;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.DefaultValue;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.TourService;
import by.it_academy.agency.utils.Pagination;

import javax.servlet.http.HttpServletRequest;

public class GoToSetDiscountCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SET_DISCOUNT_PAGE_PATH);
            request.getSession().setAttribute(Parameters.COUNT_TOURS_PER_PAGE, DefaultValue.COUNT_RECORDS_PER_PAGE);
            request.setAttribute(Parameters.TOURS_MAP, new TourService().getToursMapLimit(DefaultValue.START_RECORD, DefaultValue.COUNT_RECORDS_PER_PAGE));
            request.setAttribute(Parameters.PAGINATION_MENU, new Pagination().getPaginationMenu(DefaultValue.START_PAGE, DefaultValue.COUNT_RECORDS_PER_PAGE));
        } catch (Exception e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}