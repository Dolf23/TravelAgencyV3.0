package by.it_academy.TravelAgency.connectionpool;

import by.it_academy.TravelAgency.constants.DBConfig;
import by.it_academy.TravelAgency.logger.logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionPool {
    INSTANCE;

    private DataSource dataSource;
    private Connection connection;

    {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(DBConfig.DATABASE_SOURCE);
        } catch (NamingException e) {
            logger.writeLog(e.getMessage());
        }
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
