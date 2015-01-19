package com.jgefroh.hog.core;

import java.util.Arrays;
import java.util.List;




public class FieldDefinition {
    private final String name;
    private final String type;
    private List<FieldAttribute> attributes;
    
    public FieldDefinition(String name, String type, FieldAttribute ... attributes) {
        this.name = name;
        this.type = type;
        this.attributes = Arrays.asList((attributes));
    }
    

    public String getName() {
        return this.name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public List<FieldAttribute> getAttributes() {
        return this.attributes;
    }
    
    public boolean isId() {
        return attributes.contains(FieldAttribute.ID_FIELD);
    }
    
    public boolean typeIs(final String name) {
        return type.equals(name) || type.endsWith("<" + name + ">");
    }
    
    public String getBaseType() {
        String t = type.toString();
        if (t.contains("<")) {
            return t.substring(t.indexOf('<') + 1, t.length() - 1);
        }
        else {
            return t;
        }
    }
    
    public boolean isCollection() {
        return attributes.contains(FieldAttribute.ELEMENT_COLLECTION)
                || attributes.contains(FieldAttribute.MANY_TO_MANY)
                || attributes.contains(FieldAttribute.MANY_TO_ONE);
    }
    
    public boolean isElementCollection() {
        return attributes.contains(FieldAttribute.ELEMENT_COLLECTION);
    }

    public boolean isOneToOne() {
        return attributes.contains(FieldAttribute.ONE_TO_ONE);
    }

    public boolean isOneToMany() {
        return attributes.contains(FieldAttribute.ONE_TO_MANY);
    }

    public boolean isManyToOne() {
        return attributes.contains(FieldAttribute.MANY_TO_ONE);
    }
    
    public boolean isManyToMany() {
        return attributes.contains(FieldAttribute.MANY_TO_MANY);
    }
    
    public boolean isLazy() {
        return attributes.contains(FieldAttribute.LAZY_LOADED);
    }

    public boolean isBaseType() {
        String t = type.toString().toLowerCase();
        return t.contains("integer")
                || t.contains("date")
                || t.contains("string")
                || t.contains("bigdecimal")
                || t.contains("long")
                || t.contains("short")
                || t.contains("byte")
                || t.contains("double")
                || t.contains("float")
                || t.contains("boolean");
    }
}
