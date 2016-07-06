package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.exceptions.ServiceException;

import java.util.Map;

public interface ITourService extends IService<Tour> {
    void makeDiscount(int idTour, int amountDiscount) throws ServiceException;

    Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws ServiceException;

    String convertTourToString(int id) throws ServiceException;

    Map<Integer, String> getToursMapLimit(int startRecord, int sizePage) throws ServiceException;

    int getCountTours() throws ServiceException;
}
