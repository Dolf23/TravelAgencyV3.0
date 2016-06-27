package by.it_academy.agency.utils;

import by.it_academy.agency.constants.DefaultValue;
import by.it_academy.agency.exceptions.PaginationException;
import by.it_academy.agency.logger.logger;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    public List<String> getPaginationMenu(int selectPage, int quantityPerPage) throws PaginationException {
        try {
//            TourService tourService = new TourService();
//            int countTours = tourService.getCountTours();
            int countTours = 1285;
            List<String> list = new ArrayList<>();

            int countPages;
            if (countTours % quantityPerPage == 0) {
                countPages = countTours / quantityPerPage;
            } else {
                countPages = countTours / quantityPerPage + 1;
            }

            if (countPages > DefaultValue.COUNT_PAGES_IN_PAGINATION_MENU) {
                if (selectPage == 1) {
                    for (int i = 1; i <= DefaultValue.COUNT_PAGES_BEFORE_GAP; i++) {
                        list.add(Integer.toString(i));
                    }
                } else {
                    list.add("1");
                    for (int i = 1; i <= 3; i++) {
                        list.add(Integer.toString(selectPage + i));
                    }
                }

                for (int i = countPages - DefaultValue.COUNT_PAGES_AFTER_GAP; i <= countPages; i++) {
                    list.add(Integer.toString(i));
                }
            } else {
                for (int i = 1; i <= countPages; i++) {
                    list.add(Integer.toString(i));
                }
            }

            return list;
        } catch (Exception e) {
            logger.writeLog("Pagination getPaginationMenu error:" + e.getMessage());
            throw new PaginationException();
        }

    }
}
