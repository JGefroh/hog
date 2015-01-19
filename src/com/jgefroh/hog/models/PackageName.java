package com.jgefroh.hog.models;

public class PackageName {
    
    public final String name;
    
    public PackageName(final String name) {
        this.name = name;
    }
    
    public static PackageName PackageName(String name) {
        return new PackageName(name);
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    public String asRelativePath() {
        return name.replace(".", "\\") + "\\";
    }
}
