package com.jgefroh.hog.models;




public class ModelType {
    
    public final String type;
    
    public ModelType(final String type) {
        this.type = type;
    }
    
    public static ModelType ModelType(String type) {
        return new ModelType(type);
    }
}
