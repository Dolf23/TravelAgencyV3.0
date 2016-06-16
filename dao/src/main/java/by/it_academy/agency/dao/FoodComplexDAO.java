package by.it_academy.agency.dao;


import by.it_academy.agency.beans.Entity;
import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public enum FoodComplexDAO implements DAO {
    INSTANCE;

    @Override
    public List<FoodComplex> getAll() {
        Session session = HibernateUtil.getSession();
        List<FoodComplex> list = session.createQuery(SQLRequests.GET_ALL_FOOD_COMPLEXES).list();
        return list;
    }

    @Override
    public void createEntity(Entity foodComplex) {

    }

    @Override
    public FoodComplex getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        FoodComplex foodComplex = (FoodComplex) session.get(FoodComplex.class, id);
        return foodComplex;
    }

    public FoodComplex getEntityByFoodComplex(String foodComplex) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(FoodComplex.class);
        criteria.add(Restrictions.eq(ColumnNames.FOOD_COMPLEXES_FOOD_COMPLEX, foodComplex));
        FoodComplex foodComplexOut = (FoodComplex) criteria.uniqueResult();
        return foodComplexOut;
    }
}
