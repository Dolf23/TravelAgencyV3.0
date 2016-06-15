package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;
import java.util.List;


public enum RoleDAO implements DAO<Role> {
    INSTANCE;

    @Override
    public List<Role> getAll() {
        Session session = HibernateUtil.getSession();
        List<Role> list = session.createQuery(SQLRequests.GET_ALL_ROLES).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(Role role) {

    }

    @Override
    public Role getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Role role = (Role) session.get(Role.class, id);
        HibernateUtil.releaseSession(session);
        return role;
    }

    public Role getEntityByRole(String role) {
        Session session = HibernateUtil.getSession();
        Role roleOut = (Role) session.get(Role.class, role);
        HibernateUtil.releaseSession(session);
        return roleOut;
    }
}
