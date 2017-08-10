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

public class BerlinClock {

    private static final String NEWLINE = "\n";
    private int hours;
    private int minutes;
    private int seconds;

    public String getTime() {
        StringBuilder s = new StringBuilder();
        s.append(getSeconds());
        s.append(getHours());
        s.append(getMinutes());
        return s.toString();
    }

    public void setTime(String t) {
        String[] pieces = t.split(":");
        setHours(pieces[0]);
        setMinutes(pieces[1]);
        setSeconds(pieces[2]);
    }

    public String getSeconds() {
        if (seconds % 2 == 0) {
            return YELLOW.getValue() + NEWLINE;
        } else {
            return OFF.getValue() + NEWLINE;
        }
    }

    public String getHours() {
        int quotient = hours / 5;
        int remainder = hours % 5;
        StringBuilder s = new StringBuilder();
        s.append(rowOfFour(quotient));
        s.append(NEWLINE);
        s.append(rowOfFour(remainder));
        s.append(NEWLINE);
        return s.toString();
    }

    public String getMinutes() {
        int quotient = minutes / 5;
        int remainder = minutes % 5;
        StringBuilder s = new StringBuilder();
        s.append(rowOfEleven(quotient));
        s.append(NEWLINE);
        s.append(rowOfFour(remainder).replace(RED.getValue(), YELLOW.getValue()));
        s.append(NEWLINE);
        return s.toString();
    }

    private void setSeconds(String s) {
        int i = Integer.parseInt(s);
        if (i >= 0 && i <= 59) {
            seconds = i;
        } else {
            throw new IllegalArgumentException(
                    "seconds must be between 0 and 59"
            );
        }
    }

    private void setMinutes(String s) {
        int i = Integer.parseInt(s);
        if (i >= 0 && i <= 59) {
            minutes = i;
        } else {
            throw new IllegalArgumentException(
                    "minutes must be between 0 and 59"
            );
        }
    }

    private void setHours(String s) {
        int i = Integer.parseInt(s);
        if (i >= 0 && i <= 24) {
            hours = i;
        } else {
            throw new IllegalArgumentException(
                    "hours must be between 0 and 24"
            );
        }
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
