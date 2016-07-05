package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.exceptions.DAOException;

public interface IHotelTypeDAO extends DAO<HotelType> {
    HotelType getEntityByHotelType(String hotelType) throws DAOException;
}
