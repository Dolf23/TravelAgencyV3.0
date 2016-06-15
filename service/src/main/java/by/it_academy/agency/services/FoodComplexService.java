package by.it_academy.agency.services;

import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.dao.FoodComplexDAO;

import java.util.List;

public class FoodComplexService implements IService<FoodComplex> {
    @Override
    public void add(FoodComplex foodComplex) {

    }

    @Override
    public void update(FoodComplex foodComplex) {

    }

    @Override
    public FoodComplex getById(int id) {
        return FoodComplexDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<FoodComplex> getAll() {
        return FoodComplexDAO.INSTANCE.getAll();
    }

    public FoodComplex getIdByFoodComplex(String foodComplex) {
        return FoodComplexDAO.INSTANCE.getIdByFoodComplex(foodComplex);
    }
}
