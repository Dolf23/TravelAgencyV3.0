package by.it_academy.agency.dao;

import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.HibernateException;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<TYPE> implements DAO<TYPE> {
    @Override
    public List<TYPE> getAll() throws DAOException {
        List<TYPE> list;
        try {
            list = HibernateUtil.getSession().createCriteria(getTypeClass()).list();
        } catch (HibernateException e) {
            logger.writeLog("Get all entities error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    @Override
    public void createEntity(TYPE type) throws DAOException {
        try {
            HibernateUtil.getSession().save(type);
        } catch (HibernateException e) {
            logger.writeLog("Create entity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public TYPE getEntityByID(int id) throws DAOException {
        TYPE entity;
        try {
            entity = (TYPE) HibernateUtil.getSession().get(getTypeClass(), id);
        } catch (HibernateException e) {
            logger.writeLog("Find entity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return entity;
    }


    private Class getTypeClass() {
        return (Class<TYPE>) ((ParameterizedType) getTypeClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}