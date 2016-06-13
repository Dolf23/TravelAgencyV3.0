package by.it_academy.agency.constants;

public class SQLRequests {
    public static final String GET_ALL_ACTIONS = "SELECT * FROM actions;";
    public static final String ADD_ACTION = String.format("INSERT INTO actions(%s, %s, %s) VALUES (?, ?, ?);", ColumnNames.ACTIONS_FK_ACTION, ColumnNames.ACTIONS_FK_USER, ColumnNames.ACTIONS_FK_TOUR);
    public static final String GET_ACTION_BY_ID = String.format("SELECT * FROM actions WHERE %s=?;", ColumnNames.ACTIONS_ID);
    public static final String GET_ACTION_BY_USER = String.format("SELECT * FROM actions WHERE %s=?;", ColumnNames.ACTIONS_FK_USER);
    public static final String DELETE_ACTION_BY_USER_AND_TOUR = String.format("DELETE FROM actions WHERE %s=? AND %s=?;", ColumnNames.ACTIONS_FK_USER, ColumnNames.ACTIONS_FK_TOUR);

    public static final String GET_ALL_ACTION_TYPES = "SELECT * FROM action_types;";
    public static final String GET_ACTION_TYPE_BY_ID = String.format("SELECT * FROM action_types WHERE %s=?;", ColumnNames.TOUR_TYPES_ID);
    public static final String GET_ID_BY_ACTION_TYPE = String.format("SELECT * FROM action_types WHERE %s=?;", ColumnNames.ACTION_TYPES_ACTION_TYPE);

    public static final String GET_ALL_COUNTRIES = "SELECT * FROM countries;";
    public static final String ADD_COUNTRY = String.format("INSERT INTO countries(%s) VALUES (?);", ColumnNames.COUNTRIES_COUNTRY);
    public static final String GET_COUNTRY_BY_ID = String.format("SELECT * FROM countries WHERE %s=?;", ColumnNames.COUNTRIES_ID);
    public static final String GET_ID_BY_COUNTRY = String.format("SELECT * FROM countries WHERE %s=?;", ColumnNames.COUNTRIES_COUNTRY);

    public static final String GET_ALL_FOOD_COMPLEXES = "SELECT * FROM food_complexes;";
    public static final String GET_FOOD_COMPLEX_BY_ID = String.format("SELECT * FROM food_complexes WHERE %s=?;", ColumnNames.FOOD_COMPLEXES_ID);
    public static final String GET_ID_BY_FOOD_COMPLEX = String.format("SELECT * FROM food_complexes WHERE %s=?;", ColumnNames.FOOD_COMPLEXES_FOOD_COMPLEX);

    public static final String GET_ALL_HOTEL_TYPES = "SELECT * FROM hotel_types;";
    public static final String GET_HOTEL_TYPE_BY_ID = String.format("SELECT * FROM hotel_types WHERE %s=?;", ColumnNames.HOTEL_TYPES_ID);
    public static final String GET_ID_BY_HOTEL = String.format("SELECT * FROM hotel_types WHERE %s=?;", ColumnNames.HOTEL_TYPES_HOTEL_TYPE);

    public static final String GET_ALL_ROLES = "SELECT * FROM roles;";
    public static final String GET_ROLE_BY_ID = String.format("SELECT * FROM roles WHERE %s=?;", ColumnNames.ROLES_ID);
    public static final String GET_ROLE_ID_BY_ROLE = String.format("SELECT * FROM roles WHERE %s=?;", ColumnNames.ROLES_ROLE);

    public static final String GET_ALL_TOURS = "SELECT * FROM tours;";
    public static final String ADD_TOUR = String.format("INSERT INTO tours(%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?);", ColumnNames.TOURS_FK_COUNTRY, ColumnNames.TOURS_FK_TOUR_TYPE, ColumnNames.TOURS_FK_TRANSPORT, ColumnNames.TOURS_FK_HOTEL_TYPE, ColumnNames.TOURS_FK_FOOD_COMPLEX, ColumnNames.TOURS_COST, ColumnNames.TOURS_DISCOUNT);
    public static final String GET_TOUR_BY_ID = String.format("SELECT * FROM tours WHERE %s=?;", ColumnNames.TOURS_ID);
    public static final String GET_TOURS_BY_REQUEST = String.format("SELECT * FROM tours WHERE %s=? AND %s=? AND %s=? AND %s=? AND %s=?;", ColumnNames.TOURS_FK_TOUR_TYPE, ColumnNames.TOURS_FK_COUNTRY, ColumnNames.TOURS_FK_TRANSPORT, ColumnNames.TOURS_FK_HOTEL_TYPE, ColumnNames.TOURS_FK_FOOD_COMPLEX);
    public static final String UPDATE_TOUR_SET_DISCOUNT = String.format("UPDATE tours SET %s=? WHERE %s=?;", ColumnNames.TOURS_DISCOUNT, ColumnNames.TOURS_ID);

    public static final String GET_ALL_TOUR_TYPES = "SELECT * FROM tour_types;";
    public static final String GET_TOUR_TYPE_BY_ID = String.format("SELECT * FROM tour_types WHERE %s=?;", ColumnNames.ACTION_TYPES_ID);
    public static final String GET_ID_BY_TOUR_TYPE = String.format("SELECT * FROM tour_types WHERE %s=?;", ColumnNames.TOUR_TYPES_TOUR_TYPE);

    public static final String GET_ALL_TRANSPORTS = "SELECT * FROM transports;";
    public static final String GET_TRANSPORT_BY_ID = String.format("SELECT * FROM transports WHERE %s=?;", ColumnNames.TRANSPORTS_ID);
    public static final String GET_ID_BY_TRANSPORT = String.format("SELECT * FROM transports WHERE %s=?;", ColumnNames.TRANSPORTS_TRANSPORT);

    public static final String GET_ALL_USERS = "SELECT * FROM users;";
    public static final String ADD_USER = String.format("INSERT INTO users(%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?);", ColumnNames.USERS_NAME, ColumnNames.USERS_SURNAME, ColumnNames.USERS_EMAIL, ColumnNames.USERS_LOGIN, ColumnNames.USERS_PASSWORD, ColumnNames.USERS_FK_ROLE);
    public static final String GET_USER_BY_ID = String.format("SELECT * FROM users WHERE %s=?;", ColumnNames.USERS_ID);
    public static final String GET_USER_BY_LOGIN = String.format("SELECT * FROM users WHERE %s=?;", ColumnNames.USERS_LOGIN);
    public static final String CHECK_AUTHORIZATION = String.format("SELECT %s, %s FROM users WHERE %s=? AND %s=?;", ColumnNames.USERS_LOGIN, ColumnNames.USERS_PASSWORD, ColumnNames.USERS_LOGIN, ColumnNames.USERS_PASSWORD);
    public static final String CHECK_ROLE = String.format("SELECT %s FROM users WHERE %s=?;", ColumnNames.USERS_FK_ROLE, ColumnNames.USERS_LOGIN);
    public static final String CHECK_LOGIN = String.format("SELECT %s FROM users WHERE %s=?;", ColumnNames.USERS_LOGIN, ColumnNames.USERS_LOGIN);
}
