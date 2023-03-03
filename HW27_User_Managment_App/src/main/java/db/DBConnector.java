package db;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private static final String CONFIG_PATH = "src/main/resources/db.properties";

    private static String url;
    private static String userName;
    private static String password;

    private static MysqlDataSource dataSource;
    private static DBConnector dbConnector;

    private DBConnector() {
    }

    public static DBConnector getInstance() {
        if (dbConnector == null) {
            init();

            dataSource = new MysqlDataSource();
            dataSource.setUrl(url);
            dataSource.setUser(userName);
            dataSource.setPassword(password);

            dbConnector = new DBConnector();
        }
        return dbConnector;
    }

    private static void init() {
        Properties properties = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        url = properties.getProperty("db.url");
        userName = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
