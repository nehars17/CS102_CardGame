// package main;

import java.util.ArrayList;

public class Card {
    String value;
    String type;

    Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        return value + type;
    }

    public int getValue() {
        if (value == "j") {
            value = "11";
        }
        if (value == "q") {
            value = "12";
        }
        if (value == "k") {
            value = "13";
        }
        if (value == "a") {
            value = "14";
        }
        if (value == "2") {
            value = "12";
        }

        if (type == "d") {
            type = "1";
        }
        if (type == "c") {
            type = "2";
        }
        if (type == "h") {
            type = "3";
        }
        if (type == "s") {
            type = "4";
        }

        return Integer.parseInt(value + type); 
    }

    public String getImagePath() {
        return "./images/" + toString() + ".gif";
    }
}
