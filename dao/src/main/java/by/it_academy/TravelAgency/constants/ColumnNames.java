package by.it_academy.TravelAgency.constants;

public class ColumnNames {
    public static final String ACTIONS_ID = "id";
    public static final String ACTIONS_FK_ACTION = "fk_action";
    public static final String ACTIONS_FK_USER = "fk_user";
    public static final String ACTIONS_FK_TOUR = "fk_tour";

    public static final String ACTION_TYPES_ID = "id";
    public static final String ACTION_TYPES_ACTION_TYPE = "action_type";

    public static final String COUNTRIES_ID = "id";
    public static final String COUNTRIES_COUNTRY = "country";

    public static final String FOOD_COMPLEXES_ID = "id";
    public static final String FOOD_COMPLEXES_FOOD_COMPLEX = "food_complex";

    public static final String HOTEL_TYPES_ID = "id";
    public static final String HOTEL_TYPES_HOTEL_TYPE = "hotel_type";

    public static final String ROLES_ID = "id";
    public static final String ROLES_ROLE = "role";

    public static final String TOURS_ID = "id";
    public static final String TOURS_FK_COUNTRY = "fk_country";
    public static final String TOURS_FK_TOUR_TYPE = "fk_tour_type";
    public static final String TOURS_FK_TRANSPORT = "fk_transport";
    public static final String TOURS_FK_HOTEL_TYPE = "fk_hotel_type";
    public static final String TOURS_FK_FOOD_COMPLEX = "fk_food_complex";
    public static final String TOURS_COST = "cost";
    public static final String TOURS_DISCOUNT = "discount";

    public static final String TOUR_TYPES_ID = "id";
    public static final String TOUR_TYPES_TOUR_TYPE = "tour_type";

    public static final String TRANSPORTS_ID = "id";
    public static final String TRANSPORTS_TRANSPORT = "transport";

    public static final String USERS_ID = "id";
    public static final String USERS_NAME = "name";
    public static final String USERS_SURNAME = "surname";
    public static final String USERS_EMAIL = "email";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_FK_ROLE = "fk_role";
}
