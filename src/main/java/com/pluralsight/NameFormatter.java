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
        String prefix = "";
        boolean prefixFound = false;
        String firstName = split[0];
        String lastName = "";
        String middleName = "";
        String suffix = "";

        if (split.length == 2) {
            return split[1] + ", " + split[0];
        }

        if (split[0].charAt(split[0].length() - 1) == ('.')) {
            prefix = split[0];
            prefixFound = true;
            firstName = split[1];
        }
        int secondLast = split.length - 2;
        String value = split[secondLast];
        if (value.charAt(value.length() - 1) == ',') {
            suffix = split[split.length - 1];
            lastName = split[secondLast];
            if (!(firstName.equals(split[split.length - 3]))) {
                middleName = split[secondLast - 1];
            }
        } else lastName = split[split.length - 1];

        return format(prefix, firstName, middleName, lastName, suffix);

    }


}

