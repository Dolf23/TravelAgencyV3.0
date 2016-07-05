package by.it_academy.agency.dao;

import by.it_academy.agency.dao.interfaces.DAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {

    protected SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() throws DAOException {
        List<T> list;
        try {
            list = (List<T>) currentSession().createCriteria(getTypeClass()).list();
        } catch (HibernateException e) {
            logger.writeLog("Get all entities error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    @Override
    public void createEntity(T type) throws DAOException {
        try {
            currentSession().save(type);
        } catch (HibernateException e) {
            logger.writeLog("Create entity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public T getEntityByID(int id) throws DAOException {
        T entity;
        try {
            entity = (T) currentSession().get(getTypeClass(), id);
        } catch (HibernateException e) {
            logger.writeLog("Find entity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return entity;
    }


    private Class getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}