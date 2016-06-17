package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class RoleDAO extends AbstractDAO<Role> {

    public Role getEntityByRole(String role) throws DAOException {
        Role roleOut;
        try {
            Session session = HibernateUtil.getSession();
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