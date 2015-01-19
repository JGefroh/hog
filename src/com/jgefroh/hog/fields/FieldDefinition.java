package com.jgefroh.hog.fields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jgefroh.hog.models.ModelName;




public class FieldDefinition {
    private final FieldName name;
    private final FieldType type;
    private List<FieldAttribute> attributes;
    
    private FieldDefinition(FieldName name, FieldType type, List<FieldAttribute> attributes) {
        this.name = name;
        this.type = type;
        this.attributes = new ArrayList<FieldAttribute>(attributes);
    }
    
    public static FieldDefinition FieldDefinition(FieldName name, FieldType type, FieldAttribute ... attributes) {
        return new FieldDefinition(name, type, Arrays.asList(attributes));
    }
    
    public FieldName getName() {
        return name;
    }
    
    public FieldType getType() {
        return type;
    }
    
    public List<FieldAttribute> getAttributes() {
        return this.attributes;
    }
    
    public boolean isId() {
        return attributes.contains(FieldAttribute.ID);
    }
    
    public boolean typeIs(final ModelName name) {
        return type.toString().equals(name.toString()) || type.toString().endsWith("<" + name.toString() + ">");
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
        return attributes.contains(FieldAttribute.LAZY);
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
