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

    public static String format(String fullName) {
        String[] split = fullName.split(" ");
        boolean prefix = false;
        boolean middle = false;
        boolean suffix = false;
        String firstName = "";
        String lastName = "";
        String middleName = "";

        if (split.length == 2) {
            return split[1] + ", " + split[0];
        }

        if (split[split[0].length() - 1] == ".") {
            prefix = true;
            firstName = split[1];
        }
        int secondLast = split.length - 2;
        String value = split[secondLast];
        if (value.charAt(value.length() - 1) == ',') {
            suffix = true;
            lastName = split[secondLast];
            if (!(firstName.equals(split.length - 3))) {
                middle = true;
                middleName = split[secondLast - 1];
            }
        } else lastName = split[split.length - 1];

        fullName += lastName + ", ";
        if (prefix) fullName += split[0];
        fullName += firstName + " ";
        if (middle) fullName += middleName;
        fullName += lastName;
        if (suffix) fullName += split[secondLast] + 1;
        return fullName;

    }


}

