package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.exceptions.DAOException;

public interface IFoodComplexDAO extends DAO<FoodComplex> {
    FoodComplex getEntityByFoodComplex(String foodComplex) throws DAOException;
}
