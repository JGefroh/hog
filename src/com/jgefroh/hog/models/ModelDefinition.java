package com.jgefroh.hog.models;

import java.util.ArrayList;
import java.util.List;

import com.jgefroh.hog.fields.FieldDefinition;

public class ModelDefinition {
    
    private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
    private final ModelName name;
    private final PackageName packageName;
    
    
    public static ModelDefinition ModelDefinition(ModelName name, PackageName packageName) {
        return new ModelDefinition(name, packageName);
    }
    
    public ModelDefinition(final ModelName name, final PackageName packageName) {
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
    
    
    
    public ModelName getName() {
        return name;
    }
    
    public PackageName getPackageName() {
        return packageName;
    }
}
