package by.it_academy.agency.services;

import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.dao.interfaces.IFoodComplexDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IFoodComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class FoodComplexService implements IFoodComplexService {

    private IFoodComplexDAO dao;

    @Autowired
    public FoodComplexService(IFoodComplexDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(FoodComplex foodComplex) {

    }

    @Override
    public void update(FoodComplex foodComplex) {

    }

    @Override
    public FoodComplex getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("FoodComplexService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<FoodComplex> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("FoodComplexService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public FoodComplex getEntityByFoodComplex(String foodComplex) throws ServiceException {
        try {
            return dao.getEntityByFoodComplex(foodComplex);
        } catch (DAOException e) {
            logger.writeLog("FodComplexService getEntityByComplex error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
