package by.it_academy.TravelAgency.constants;

import static by.it_academy.TravelAgency.constants.ColumnNames.*;

public class SQLRequests {
    public static final String GET_ALL_ACTIONS = "SELECT * FROM actions;";
    public static final String ADD_ACTION = String.format("INSERT INTO actions(%s, %s, %s) VALUES (?, ?, ?);", ACTIONS_FK_ACTION, ACTIONS_FK_USER, ACTIONS_FK_TOUR);
    public static final String GET_ACTION_BY_ID = String.format("SELECT * FROM actions WHERE %s=?;", ACTIONS_ID);
    public static final String GET_ACTION_BY_USER = String.format("SELECT * FROM actions WHERE %s=?;", ACTIONS_FK_USER);
    public static final String DELETE_ACTION_BY_USER_AND_TOUR = String.format("DELETE FROM actions WHERE %s=? AND %s=?;", ACTIONS_FK_USER, ACTIONS_FK_TOUR);

    public static final String GET_ALL_ACTION_TYPES = "SELECT * FROM action_types;";
    public static final String GET_ACTION_TYPE_BY_ID = String.format("SELECT * FROM action_types WHERE %s=?;", TOUR_TYPES_ID);
    public static final String GET_ID_BY_ACTION_TYPE = String.format("SELECT * FROM action_types WHERE %s=?;", ACTION_TYPES_ACTION_TYPE);

    public static final String GET_ALL_COUNTRIES = "SELECT * FROM countries;";
    public static final String ADD_COUNTRY = String.format("INSERT INTO countries(%s) VALUES (?);", COUNTRIES_COUNTRY);
    public static final String GET_COUNTRY_BY_ID = String.format("SELECT * FROM countries WHERE %s=?;", COUNTRIES_ID);
    public static final String GET_ID_BY_COUNTRY = String.format("SELECT * FROM countries WHERE %s=?;", COUNTRIES_COUNTRY);

    public static final String GET_ALL_FOOD_COMPLEXES = "SELECT * FROM food_complexes;";
    public static final String GET_FOOD_COMPLEX_BY_ID = String.format("SELECT * FROM food_complexes WHERE %s=?;", FOOD_COMPLEXES_ID);
    public static final String GET_ID_BY_FOOD_COMPLEX = String.format("SELECT * FROM food_complexes WHERE %s=?;", FOOD_COMPLEXES_FOOD_COMPLEX);

    public static final String GET_ALL_HOTEL_TYPES = "SELECT * FROM hotel_types;";
    public static final String GET_HOTEL_TYPE_BY_ID = String.format("SELECT * FROM hotel_types WHERE %s=?;", HOTEL_TYPES_ID);
    public static final String GET_ID_BY_HOTEL = String.format("SELECT * FROM hotel_types WHERE %s=?;", HOTEL_TYPES_HOTEL_TYPE);

    public static final String GET_ALL_ROLES = "SELECT * FROM roles;";
    public static final String GET_ROLE_BY_ID = String.format("SELECT * FROM roles WHERE %s=?;", ROLES_ID);
    public static final String GET_ROLE_ID_BY_ROLE = String.format("SELECT * FROM roles WHERE %s=?;", ROLES_ROLE);

    public static final String GET_ALL_TOURS = "SELECT * FROM tours;";
    public static final String ADD_TOUR = String.format("INSERT INTO tours(%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?);", TOURS_FK_COUNTRY, TOURS_FK_TOUR_TYPE, TOURS_FK_TRANSPORT, TOURS_FK_HOTEL_TYPE, TOURS_FK_FOOD_COMPLEX, TOURS_COST, TOURS_DISCOUNT);
    public static final String GET_TOUR_BY_ID = String.format("SELECT * FROM tours WHERE %s=?;", TOURS_ID);
    public static final String GET_TOURS_BY_REQUEST = String.format("SELECT * FROM tours WHERE %s=? AND %s=? AND %s=? AND %s=? AND %s=?;", TOURS_FK_TOUR_TYPE, TOURS_FK_COUNTRY, TOURS_FK_TRANSPORT, TOURS_FK_HOTEL_TYPE, TOURS_FK_FOOD_COMPLEX);
    public static final String UPDATE_TOUR_SET_DISCOUNT = String.format("UPDATE tours SET %s=? WHERE %s=?;", TOURS_DISCOUNT, TOURS_ID);

    public static final String GET_ALL_TOUR_TYPES = "SELECT * FROM tour_types;";
    public static final String GET_TOUR_TYPE_BY_ID = String.format("SELECT * FROM tour_types WHERE %s=?;", ACTION_TYPES_ID);
    public static final String GET_ID_BY_TOUR_TYPE = String.format("SELECT * FROM tour_types WHERE %s=?;", TOUR_TYPES_TOUR_TYPE);

    public static final String GET_ALL_TRANSPORTS = "SELECT * FROM transports;";
    public static final String GET_TRANSPORT_BY_ID = String.format("SELECT * FROM transports WHERE %s=?;", TRANSPORTS_ID);
    public static final String GET_ID_BY_TRANSPORT = String.format("SELECT * FROM transports WHERE %s=?;", TRANSPORTS_TRANSPORT);

    public static final String GET_ALL_USERS = "SELECT * FROM users;";
    public static final String ADD_USER = String.format("INSERT INTO users(%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?);", USERS_NAME, USERS_SURNAME, USERS_EMAIL, USERS_LOGIN, USERS_PASSWORD, USERS_FK_ROLE);
    public static final String GET_USER_BY_ID = String.format("SELECT * FROM users WHERE %s=?;", USERS_ID);
    public static final String GET_USER_BY_LOGIN = String.format("SELECT * FROM users WHERE %s=?;", USERS_LOGIN);
    public static final String CHECK_AUTHORIZATION = String.format("SELECT %s, %s FROM users WHERE %s=? AND %s=?;", USERS_LOGIN, USERS_PASSWORD, USERS_LOGIN, USERS_PASSWORD);
    public static final String CHECK_ROLE = String.format("SELECT %s FROM users WHERE %s=?;", USERS_FK_ROLE, USERS_LOGIN);
    public static final String CHECK_LOGIN = String.format("SELECT %s FROM users WHERE %s=?;", USERS_LOGIN, USERS_LOGIN);
}
