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
        return session.createQuery(SQLRequests.GET_ALL_FOOD_COMPLEXES).list();
    }

    @Override
    public void createEntity(Entity foodComplex) {

    }

    @Override
    public Entity getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (FoodComplex) session.get(FoodComplex.class, id);
    }
}
