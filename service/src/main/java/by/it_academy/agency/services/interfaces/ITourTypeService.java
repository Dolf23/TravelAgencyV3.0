package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.exceptions.ServiceException;

public interface ITourTypeService extends IService<TourType> {
    TourType getEntityByTourType(String tourType) throws ServiceException;
}
