package by.it_academy.agency.services;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.dao.HotelTypeDAO;
import java.util.List;

public class HotelTypeService implements IService<HotelType> {
    @Override
    public void add(HotelType hotelType) {

    }

    @Override
    public void update(HotelType hotelType) {

    }

    @Override
    public HotelType getById(int id) {
        return HotelTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<HotelType> getAll() {
        return HotelTypeDAO.INSTANCE.getAll();
    }

    public HotelType getIdByHotelType(String hotelType) {
        return HotelTypeDAO.INSTANCE.getEntityByHotelType(hotelType);
    }
}
