package by.it_academy.agency.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> sessions = new ThreadLocal();

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException("Configuration problem: " + e.getMessage(), e);
        }
    }

    public static Session getSession() throws HibernateException {
        Session session = sessions.get();

        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public static void closeSession(Session session) throws HibernateException {
        if (session != null) {
            session.close();
            sessions.remove();
        }
    }
}
