package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.exceptions.ServiceException;

public interface IHotelTypeService extends IService<HotelType> {
    HotelType getEntityByHotelType(String hotelType) throws ServiceException;
}
