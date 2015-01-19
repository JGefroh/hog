package com.jgefroh.hog.fields;


public class FieldType {

    private final String type;

    public FieldType(final String type) {
        this.type = type;
    }

    public static FieldType FieldType(String type) {
        return new FieldType(type);
    }
    
    @Override
    public String toString() {
        return this.type;
    }
}
