package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public enum RoleDAO implements DAO<Role> {
    INSTANCE;

    @Override
    public List<Role> getAll() {
        Session session = HibernateUtil.getSession();
        List<Role> list = session.createQuery(SQLRequests.GET_ALL_ROLES).list();
        return list;
    }

    @Override
    public void createEntity(Role role) {

    }

    @Override
    public Role getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Role role = (Role) session.get(Role.class, id);
        return role;
    }

    public Role getEntityByRole(String role) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq(ColumnNames.ROLES_ROLE, role));
        Role roleOut = (Role) criteria.uniqueResult();
        return roleOut;
    }
}
