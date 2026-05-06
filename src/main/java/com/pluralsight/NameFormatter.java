package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {
    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        String fullName = lastName + ", ";
        if (prefix != "") {
            fullName += prefix + " ";
        }
        fullName += firstName;
        if (middleName != "") {
            fullName += middleName;
        }
        if (suffix != "") {
            fullName += ", " + suffix;
        }
        return fullName;
    }

}

