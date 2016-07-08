package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.exceptions.ServiceException;

import java.util.Map;

public interface IActionService extends IService<Action> {
    Map<Integer, String> getUserActions(User user) throws ServiceException;

    void deleteAction(User user, int idTour) throws ServiceException;

    void reserveTour(Tour tour, User user, String actionType) throws ServiceException;
}
