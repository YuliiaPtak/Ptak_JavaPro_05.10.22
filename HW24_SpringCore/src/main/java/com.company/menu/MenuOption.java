package com.company.menu;

public enum MenuOption {
    DISPLAY_PRODUCTS,
    ADD_TO_CART,
    REMOVE_FROM_CART,
    DISPLAY_CART,
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
