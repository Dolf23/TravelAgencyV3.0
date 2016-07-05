package by.it_academy.agency.dao;


import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.dao.interfaces.IFoodComplexDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodComplexDAO extends AbstractDAO<FoodComplex> implements IFoodComplexDAO {

    @Autowired
    private FoodComplexDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FoodComplex getEntityByFoodComplex(String foodComplex) throws DAOException {
        FoodComplex foodComplexOut;
        try {
            Session session = currentSession();
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