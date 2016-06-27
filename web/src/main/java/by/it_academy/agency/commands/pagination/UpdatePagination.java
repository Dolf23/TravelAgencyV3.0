package by.it_academy.agency.commands.pagination;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.TourService;
import by.it_academy.agency.utils.Pagination;

import javax.servlet.http.HttpServletRequest;

public class UpdatePagination extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SET_DISCOUNT_PAGE_PATH);

            int quantityPerPage;
            int selectedPage;
            String quantityPerPageString = request.getParameter(Parameters.QUANTITY_PER_PAGE);
            String selectedPageString = request.getParameter(Parameters.SELECTED_PAGE);
            if (quantityPerPageString != null) {
                quantityPerPage = Integer.parseInt(quantityPerPageString);
                request.getSession().setAttribute(Parameters.COUNT_TOURS_PER_PAGE, quantityPerPage);
            } else {
                quantityPerPage = (int) request.getSession().getAttribute(Parameters.COUNT_TOURS_PER_PAGE);
            }
            if (selectedPageString != null) {
                selectedPage = Integer.parseInt(selectedPageString);
            } else {
                selectedPage = 1;
            }

            request.setAttribute(Parameters.TOURS_MAP, new TourService().getToursMapLimit(selectedPage, quantityPerPage));
            request.setAttribute(Parameters.PAGINATION_MENU, new Pagination().getPaginationMenu(selectedPage, quantityPerPage));

        } catch (Exception e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
