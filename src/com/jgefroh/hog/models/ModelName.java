package com.jgefroh.hog.models;




public class ModelName {
    
    public final String name;
    
    public ModelName(final String name) {
        this.name = name;
    }
    
    public static ModelName ModelName(String name) {
        return new ModelName(name);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
