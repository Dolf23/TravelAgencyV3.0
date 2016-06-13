package by.it_academy.agency.commands.admin;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.TourService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class SetDiscountCommand extends AbstractCommand {
    private static String idTourString = "";
    private static String amountDiscountString = "";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            idTourString = request.getParameter(Parameters.DISCOUNTING_TOUR);
            amountDiscountString = request.getParameter(Parameters.AMOUNT_DISCOUNT);
            if (isFieldsFull()) {
                int idTour = Integer.parseInt(idTourString);
                int amountDiscount = Integer.parseInt(amountDiscountString);
                TourService.makeDiscount(idTour, amountDiscount);

                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            }
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private boolean isFieldsFull() {
        boolean is = false;
        if (null != amountDiscountString && null != idTourString)
            is = true;
        return is;
    }
}
