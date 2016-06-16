package by.it_academy.agency.dao;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
        Criteria criteria = session.createCriteria(HotelType.class);
        criteria.add(Restrictions.eq(ColumnNames.HOTEL_TYPES_HOTEL_TYPE, hotelType));
        HotelType hotelTypeOut = (HotelType) criteria.uniqueResult();
        HibernateUtil.releaseSession(session);
        return hotelTypeOut;
    }
}
