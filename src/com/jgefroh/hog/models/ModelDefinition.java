package com.jgefroh.hog.models;

import java.util.ArrayList;
import java.util.List;

import com.jgefroh.hog.fields.FieldDefinition;

public class ModelDefinition {
    
    private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
    private final String name;
    private final String packageName;
    
    
    public ModelDefinition(final String name, final String packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    
    
    public void addField(final FieldDefinition field) {
        fieldDefinitions.add(field);
    }
    
    public void removeField(final FieldDefinition field) {
        fieldDefinitions.remove(field);
    }
    
    
    public List<FieldDefinition> getFieldDefinitions() {
        return new ArrayList<FieldDefinition>(fieldDefinitions);
    }
    
    
    
    public String getName() {
        return name;
    }
    
    public String getPackageName() {
        return packageName;
    }
}
