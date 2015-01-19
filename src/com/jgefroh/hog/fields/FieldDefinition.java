package com.jgefroh.hog.fields;



public class FieldDefinition {
    private final FieldName name;
    private final FieldType type;
    
    public FieldDefinition(FieldName name, FieldType type) {
        this.name = name;
        this.type = type;
    }
    
    public static FieldDefinition FieldDefinition(FieldName name, FieldType type) {
        return new FieldDefinition(name, type);
    }
    
    
    
    public FieldName getName() {
        return name;
    }
    
    public FieldType getType() {
        return type;
    }
}
