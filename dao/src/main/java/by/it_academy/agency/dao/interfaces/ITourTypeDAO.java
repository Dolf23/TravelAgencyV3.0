package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.exceptions.DAOException;

public interface ITourTypeDAO extends DAO<TourType> {
    TourType getEntityByTourType(String tourType) throws DAOException;
}
