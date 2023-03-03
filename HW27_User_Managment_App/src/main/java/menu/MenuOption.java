package menu;

public enum MenuOption {
    ADD_USER,
    SHOW_ALL_USERS,
    SHOW_ALL_OLDER_USERS,
    DELETE_USER,
    UPDATE_USER,
    SHOW_USER_BY_ID,
    SHOW_USER_BY_FIRST_NAME,
    EXIT;

    public static MenuOption getOption(int commandNumber) {
        for (MenuOption value : values()) {
            if (value.ordinal() == commandNumber) {
                return value;
            }
        }
        return null;
    }
}
