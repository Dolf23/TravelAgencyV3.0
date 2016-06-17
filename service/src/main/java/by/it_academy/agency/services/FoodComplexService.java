package by.it_academy.agency.services;

import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.dao.FoodComplexDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class FoodComplexService implements IService<FoodComplex> {

    private FoodComplexDAO foodComplexDAO = new FoodComplexDAO();

    @Override
    public void add(FoodComplex foodComplex) {

    }

    @Override
    public void update(FoodComplex foodComplex) {

    }

    @Override
    public FoodComplex getById(int id) throws ServiceException {
        try {
            return foodComplexDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("FoodComplexService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<FoodComplex> getAll() throws ServiceException {
        try {
            return foodComplexDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("FoodComplexService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public FoodComplex getEntityByFoodComplex(String foodComplex) throws ServiceException {
        try {
            return foodComplexDAO.getEntityByFoodComplex(foodComplex);
        } catch (DAOException e) {
            logger.writeLog("FodComplexService getEntityByComplex error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
