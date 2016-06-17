package by.it_academy.agency.dao;


import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class FoodComplexDAO extends AbstractDAO<FoodComplex> {

    public FoodComplex getEntityByFoodComplex(String foodComplex) throws DAOException {
        FoodComplex foodComplexOut;
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(FoodComplex.class);
            criteria.add(Restrictions.eq(ColumnNames.FOOD_COMPLEXES_FOOD_COMPLEX, foodComplex));
            foodComplexOut = (FoodComplex) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("FoodComplexDAO getEntityByFoodComplex error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return foodComplexOut;
    }
}