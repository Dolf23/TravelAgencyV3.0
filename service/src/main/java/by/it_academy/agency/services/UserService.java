package by.it_academy.agency.services;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.UserDAO;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserService implements IService<User> {
    @Override
    public void add(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            UserDAO.INSTANCE.createEntity(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            logger.writeLog(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.releaseSession(session);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(int id) {
        return UserDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<User> getAll() {
        return UserDAO.INSTANCE.getAll();
    }

    public static boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.CHECK_AUTHORIZATION);
        query.setParameter(ColumnNames.USERS_LOGIN, login);
        query.setParameter(ColumnNames.USERS_PASSWORD, password);
        List list = query.list();
        if (!list.isEmpty())
            isLogIn = true;
        HibernateUtil.releaseSession(session);
        return isLogIn;
    }

    public static String checkRole(String login) {
        String roleString = "";
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.CHECK_ROLE);
        query.setParameter(ColumnNames.USERS_LOGIN, login);
        List<Integer> list = query.list();

        if (!list.isEmpty()) {
            int idRole = list.get(0);
            Role role = (Role) session.get(Role.class, idRole);
            if (role != null)
                roleString = role.getRole();
        }

        HibernateUtil.releaseSession(session);
        return roleString;
    }

    public static User getUserByLogin(String login) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.GET_USER_BY_LOGIN);
        query.setParameter(ColumnNames.USERS_LOGIN, login);
        List<User> list = query.list();
        User user = null;
        if (!list.isEmpty()) {
            user = list.get(0);
        }
        HibernateUtil.releaseSession(session);
        return user;
    }

    public static boolean isNewUser(String login) {
        boolean isNew = true;
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.CHECK_LOGIN);
        query.setParameter(ColumnNames.USERS_LOGIN, login);
        List list = query.list();
        if (!list.isEmpty())
            isNew = false;
        HibernateUtil.releaseSession(session);
        return isNew;
    }
}
