package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.constants.ColumnNames;
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
public class RoleDAO extends AbstractDAO<Role> {

    @Autowired
    private RoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Role getEntityByRole(String role) throws DAOException {
        Role roleOut;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq(ColumnNames.ROLES_ROLE, role));
            roleOut = (Role) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("RoleDAO getEntityByRole error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return roleOut;
    }
}