package menu;

import db.dao.UserDAO;
import pojo.User;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final UserDAO USER_DAO = new UserDAO();

    public static void run() {
        System.out.println("Menu options:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.ordinal() + " - " + option.toString().toLowerCase());
        }

        MenuOption option;
        do {
            option = selectOption();
            switch (option) {
                case ADD_USER -> addUser();
                case SHOW_ALL_USERS -> showAllUsers();
                case SHOW_ALL_OLDER_USERS -> showOlderUsers();
                case DELETE_USER -> deleteUser();
                case UPDATE_USER -> updateUser();
                case SHOW_USER_BY_ID -> showUserById();
                case SHOW_USER_BY_FIRST_NAME -> showUserByFirstName();
                case EXIT -> System.out.println("Bye, have a nice day!");
            }
        } while (!MenuOption.EXIT.equals(option));
    }

    private static MenuOption selectOption() {
        System.out.println("--------------------");
        int userOption = readInt("Choose option");
        MenuOption menuOption = MenuOption.getOption(userOption);
        if (menuOption == null) {
            System.out.println("Unknown option " + userOption);
            return selectOption();
        }
        return menuOption;
    }

    private static void addUser() {
        USER_DAO.addUser(new User(
                readString("Enter first name"),
                readString("Enter last name"),
                readInt("Enter age")
        ));
    }

    private static void showAllUsers() {
        print(USER_DAO.getUsers());
    }

    private static void showOlderUsers() {
        print(USER_DAO.getOlderUsers(readInt("Enter age")));
    }

    private static void deleteUser() {
        User user = USER_DAO.getUserById(readInt("Enter id"));
        if (user == null) {
            System.out.println("User not found!");
        } else {
            USER_DAO.deleteUser(user.getId());
        }
    }

    private static void updateUser() {
        User oldUser = USER_DAO.getUserById(readInt("Enter id"));
        if (oldUser == null) {
            System.out.println("User not found!");
            return;
        }

        User newUser = new User(
                readString("Enter first name, or type \"null\""),
                readString("Enter last name, or type \"null\""),
                readInt("Enter age, or type 0")
        );

        USER_DAO.update(buildFullUser(newUser, oldUser));
    }

    private static User buildFullUser(User newUser, User oldUser) {
        if (newUser.getFirstName() == null || "null".equalsIgnoreCase(newUser.getFirstName())) {
            newUser.setFirstName(oldUser.getFirstName());
        }
        if (newUser.getLastName() == null || "null".equalsIgnoreCase(newUser.getLastName())) {
            newUser.setLastName(oldUser.getLastName());
        }
        if (newUser.getAge() <= 0) {
            newUser.setAge(oldUser.getAge());
        }
        newUser.setId(oldUser.getId());
        return newUser;
    }

    private static void showUserById() {
        print(USER_DAO.getUserById(readInt("Enter id")));
    }

    private static void showUserByFirstName() {
        print(USER_DAO.getUserByFirstName(readString("Enter first name")));
    }

    private static String readString(String text) {
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        if (next == null || next.isBlank()) {
            System.out.println("Incorrect input!");
            return readString(text);
        }
        return next;
    }

    private static int readInt(String text) {
        String next = readString(text);
        try {
            return Integer.parseInt(next);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input!");
            return readInt(text);
        }
    }

    private static void print(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("Users not found!");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void print(User user) {
        if (user == null) {
            System.out.println("User not found!");
        } else {
            System.out.println(user);
        }
    }
}
