package com.jgefroh.hog.generators.util;


public class FormatUtil {

    public static String camelCase(final String word) {
        return word.substring(0, 1).toUpperCase() + word.toString().substring(1);
    }
    
    public static String pluralize(final String name) {
        if (name.endsWith("s") || name.endsWith("x") || name.endsWith("h")) {
            return name + "es";
        }
        else if (name.endsWith("y")) {
            return name + "ies";
        }
        else {
            return name + "s";
        }
    }
}
