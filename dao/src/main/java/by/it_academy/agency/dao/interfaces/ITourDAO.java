package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.exceptions.DAOException;

import java.util.List;

public interface ITourDAO extends DAO<Tour> {
    void updateEntity(Tour tour) throws DAOException;

    List<Tour> getToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws DAOException;

    List<Tour> getToursWithLimit(int start, int size) throws DAOException;

    int getCountTours() throws DAOException;
}
