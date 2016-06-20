package by.it_academy.agency.constants;

public class ColumnNames {
    public static final String ACTIONS_ID = "id";
    public static final String ACTIONS_FK_ACTION = "action";
    public static final String ACTIONS_FK_USER = "user";
    public static final String ACTIONS_FK_TOUR = "tour";

    public static final String ACTION_TYPES_ID = "id";
    public static final String ACTION_TYPES_ACTION_TYPE = "actionType";

    public static final String COUNTRIES_ID = "id";
    public static final String COUNTRIES_COUNTRY = "country";

    public static final String FOOD_COMPLEXES_ID = "id";
    public static final String FOOD_COMPLEXES_FOOD_COMPLEX = "foodComplex";

    public static final String HOTEL_TYPES_ID = "id";
    public static final String HOTEL_TYPES_HOTEL_TYPE = "hotelType";

    public static final String ROLES_ID = "id";
    public static final String ROLES_ROLE = "role";

    public static final String TOURS_ID = "id";
    public static final String TOURS_FK_COUNTRY = "country";
    public static final String TOURS_FK_TOUR_TYPE = "tourType";
    public static final String TOURS_FK_TRANSPORT = "transport";
    public static final String TOURS_FK_HOTEL_TYPE = "hotelType";
    public static final String TOURS_FK_FOOD_COMPLEX = "foodComplex";
    public static final String TOURS_COST = "cost";
    public static final String TOURS_DISCOUNT = "discount";

    public static final String TOUR_TYPES_ID = "id";
    public static final String TOUR_TYPES_TOUR_TYPE = "tourType";

    public static final String TRANSPORTS_ID = "id";
    public static final String TRANSPORTS_TRANSPORT = "transport";

    public static final String USERS_ID = "id";
    public static final String USERS_NAME = "name";
    public static final String USERS_SURNAME = "surname";
    public static final String USERS_EMAIL = "email";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_FK_ROLE = "role";
}
