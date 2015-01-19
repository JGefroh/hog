package com.jgefroh.hog.fields;



public class FieldName {
    
    public final String name;
    
    public FieldName(final String name) {
        this.name = name;
    }
    
    public static FieldName FieldName(String name) {
        return new FieldName(name);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
