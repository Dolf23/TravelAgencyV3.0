package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.exceptions.ServiceException;

public interface IFoodComplexService extends IService<FoodComplex> {
    FoodComplex getEntityByFoodComplex(String foodComplex) throws ServiceException;
}
