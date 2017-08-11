package com.company.clock;


import java.util.Arrays;

import static com.company.clock.Color.*;

enum Color {

    OFF("O"),
    RED("R"),
    YELLOW("Y");


    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

class BerlinClock {

    public static final char NEWLINE = '\n';

    private String seconds;
    private String minutes;
    private String hours;

    void setTime(String t) {
        String[] parts = t.split(":");

        setHours(parts[0]);
        setMinutes(parts[1]);
        setSeconds(parts[2]);
    }

    String getTime() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getSeconds());
        stringBuilder.append(getHours());
        stringBuilder.append(getMinutes());

        return stringBuilder.toString();
    }

    public void setSeconds(String s) {
        if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 59)
            throw new IllegalArgumentException(
                    "Value of the seconds must be number between 0 and 59"
            );
        int sec = Integer.parseInt(s);
        if (sec % 2 == 0) {
            seconds = YELLOW.getValue() + NEWLINE;

        } else {
            seconds = OFF.getValue() + NEWLINE;
        }
    }

    public void setMinutes(String m) {
        if (Integer.parseInt(m) < 0 || Integer.parseInt(m) > 59)
            throw new IllegalArgumentException(
                    "Value of the minutes must be number between 0 and 59"
            );
        int integer = Integer.parseInt(m) / 5;
        int fraction = Integer.parseInt(m) % 5;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rowOfEleven(integer));
        stringBuilder.append(NEWLINE);
        stringBuilder.append(rowOfFour(fraction).replace(RED.getValue(), YELLOW.getValue()));
        stringBuilder.append(NEWLINE);

        minutes = stringBuilder.toString();
    }

    public void setHours(String h) {
        if (Integer.parseInt(h) < 0 || Integer.parseInt(h) > 24)
            throw new IllegalArgumentException(
                    "Value of the hours must be number between 0 and 59"
            );
        int integer = Integer.parseInt(h) / 5;
        int fraction = Integer.parseInt(h) % 5;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rowOfFour(integer));
        stringBuilder.append(NEWLINE);
        stringBuilder.append(rowOfFour(fraction));
        stringBuilder.append(NEWLINE);

        hours = stringBuilder.toString();
    }

    public String getSeconds() {
        return seconds;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getHours() {
        return hours;
    }


    private String rowOfFour(int value) {

        String[] off = new String[4];

        Arrays.fill(off, OFF.getValue());
        for (int i = 0; i < value; i++) {
            off[i] = RED.getValue();
        }
        return String.join("", off);
    }

    private String rowOfEleven(int value) {

        String[] off = new String[11];
        Arrays.fill(off, OFF.getValue());
        for (int i = 0; i < value; i++) {
            if ((i + 1) % 3 == 0) {
                off[i] = RED.getValue();
            } else {
                off[i] = YELLOW.getValue();
            }
        }
        return String.join("", off);


    }

}