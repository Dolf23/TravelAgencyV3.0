package by.it_academy.agency.services;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.dao.TourTypeDAO;
import java.util.List;

public class TourTypeService implements IService<TourType> {
    @Override
    public void add(TourType tourType) {

    }

    @Override
    public void update(TourType tourType) {

    }

    @Override
    public TourType getById(int id) {
        return TourTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<TourType> getAll() {
        return TourTypeDAO.INSTANCE.getAll();
    }

    public TourType getIdByTourType(String tourType) {
        return TourTypeDAO.INSTANCE.getEntityByTourType(tourType);
    }
}
