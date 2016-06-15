package by.it_academy.agency.dao;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum HotelTypeDAO implements DAO<HotelType> {
    INSTANCE;

    @Override
    public List<HotelType> getAll() {
        Session session = HibernateUtil.getSession();
        List<HotelType> list = session.createQuery(SQLRequests.GET_ALL_HOTEL_TYPES).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(HotelType hotelType) {

    }

    @Override
    public HotelType getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        HotelType hotelType = (HotelType) session.get(HotelType.class, id);
        HibernateUtil.releaseSession(session);
        return hotelType;
    }

    public HotelType getEntityByHotelType(String hotelType) {
        Session session = HibernateUtil.getSession();
        HotelType hotelTypeOut = (HotelType) session.get(HotelType.class, hotelType);
        HibernateUtil.releaseSession(session);
        return hotelTypeOut;
    }
}
