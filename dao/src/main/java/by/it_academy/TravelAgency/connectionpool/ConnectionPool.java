package by.it_academy.TravelAgency.connectionpool;

import by.it_academy.TravelAgency.constants.DBConfig;
import by.it_academy.TravelAgency.logger.logger;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public enum ConnectionPool {
    INSTANCE;

    private BasicDataSource dataSource;
    private Connection connection;

    {
        ResourceBundle bundle = ResourceBundle.getBundle(DBConfig.DATABASE);
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(bundle.getString(DBConfig.DATABASE_DRIVER));
        dataSource.setUsername(bundle.getString(DBConfig.DATABASE_USER));
        dataSource.setPassword(bundle.getString(DBConfig.DATABASE_PASSWORD));
        dataSource.setUrl(bundle.getString(DBConfig.DATABASE_URL));

    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.writeLog(e.getMessage());
            }
        }
    }

}
