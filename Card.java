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
    public int getRankVal(){
        if (value.equals("j")) {
            value = "11";
        }
        if (value.equals("q")) {
            value = "12";
        }
        if (value.equals("k")) {
            value = "13";
        }
        if (value.equals("a")) {
            value = "14";
        }
        if (value.equals("2")) {
            value = "15";
        }

        return Integer.parseInt(value);
    }
    public String getType(){
        return type;
    }
    public int getValue() {
        if (value.equals("j")) {
            value = "11";
        }
        if (value.equals("q")) {
            value = "12";
        }
        if (value.equals("k")) {
            value = "13";
        }
        if (value.equals("a")) {
            value = "14";
        }
        if (value.equals("2")) {
            value = "15";
        }

        if (type.equals("d")) {
            type = "1";
        }
        if (type.equals("c")) {
            type = "2";
        }
        if (type.equals("h")) {
            type = "3";
        }
        if (type.equals("s")) {
            type = "4";
        }

        return Integer.parseInt(value + type);
    }

    public String getImagePath() {
        return "./images/" + toString() + ".gif";
    }
}