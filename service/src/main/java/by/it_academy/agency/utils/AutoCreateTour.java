package by.it_academy.agency.utils;

import by.it_academy.agency.beans.*;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.services.*;

import java.util.ArrayList;
import java.util.List;

public class AutoCreateTour {
    public static void main(String[] args) throws ServiceException {
        List<TourType> tourTypeList = (ArrayList) new TourTypeService().getAll();
        List<Country> countryList = (ArrayList) new CountryService().getAll();
        List<Transport> transportList = (ArrayList) new TransportService().getAll();
        List<HotelType> hotelTypeList = (ArrayList) new HotelTypeService().getAll();
        List<FoodComplex> foodComplexList = (ArrayList) new FoodComplexService().getAll();
        TourService tourService = new TourService();
        for (int i = 0; i < 3; i++) {
            Tour tour = new Tour();
            tour.setTourType(tourTypeList.get((int) (Math.random() * tourTypeList.size())));
            tour.setCountry(countryList.get((int) (Math.random() * countryList.size())));
            tour.setTransport(transportList.get((int) (Math.random() * transportList.size())));
            tour.setHotelType(hotelTypeList.get((int) (Math.random() * hotelTypeList.size())));
            tour.setFoodComplex(foodComplexList.get((int) (Math.random() * foodComplexList.size())));
            tour.setCost((int) (Math.random() * 2000));
            tour.setDiscount(0);
            tourService.add(tour);
            System.out.println(tour);
        }
    }
}
