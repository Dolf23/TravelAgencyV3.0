package by.it_academy.agency.dao;


import by.it_academy.agency.beans.Entity;
import by.it_academy.agency.beans.FoodComplex;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum FoodComplexDAO implements DAO {
    INSTANCE;

    @Override
    public List<FoodComplex> getAll() {
        Session session = HibernateUtil.getSession();
        List<FoodComplex> list = session.createQuery(SQLRequests.GET_ALL_FOOD_COMPLEXES).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(Entity foodComplex) {

    }

    @Override
    public FoodComplex getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        FoodComplex foodComplex = (FoodComplex) session.get(FoodComplex.class, id);
        HibernateUtil.releaseSession(session);
        return foodComplex;
    }

    public FoodComplex getIdByFoodComplex(String foodComplex) {
        Session session = HibernateUtil.getSession();
        FoodComplex foodComplexOut = (FoodComplex) session.get(FoodComplex.class, foodComplex);
        HibernateUtil.releaseSession(session);
        return foodComplexOut;
    }
}
