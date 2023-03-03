package db.dao;

import db.DBConnector;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String ADD_USER_SCRIPT = "INSERT INTO users(first_name, last_name, age) VALUES (?, ?, ?)";
    private static final String UPDATE_USER_SCRIPT = "UPDATE users SET first_name = ?, last_name = ?, age = ? WHERE id = ?";
    private static final String GET_USERS_SCRIPT = "SELECT * FROM users";
    private static final String GET_OLDER_USERS_SCRIPT = "SELECT * FROM users WHERE age > ?";
    private static final String DELETE_USER_SCRIPT = "DELETE from users WHERE id = ?";
    private static final String GET_USER_BY_ID_SCRIPT = "SELECT * FROM users WHERE id = ?";
    private static final String GET_USER_BY_FIRST_NAME_SCRIPT = "SELECT * FROM users WHERE first_name = ?";

    public void addUser(User user) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(ADD_USER_SCRIPT)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAge());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GET_USERS_SCRIPT)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<User> users = new ArrayList<>();
                    while (resultSet.next()) {
                        users.add(buildUser(resultSet));
                    }
                    return users;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getOlderUsers(int age) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GET_OLDER_USERS_SCRIPT)) {
                statement.setInt(1, age);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<User> users = new ArrayList<>();
                    while (resultSet.next()) {
                        users.add(buildUser(resultSet));
                    }
                    return users;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_USER_SCRIPT)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID_SCRIPT)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return buildUser(resultSet);
                    }
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByFirstName(String firstName) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GET_USER_BY_FIRST_NAME_SCRIPT)) {
                statement.setString(1, firstName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return buildUser(resultSet);
                    }
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        try (Connection connection = DBConnector.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SCRIPT)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAge());
                statement.setInt(4, user.getId());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User buildUser(ResultSet resultSet) {
        try {
            return new User(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_Name"),
                    resultSet.getInt("age")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
