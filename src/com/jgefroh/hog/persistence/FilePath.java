package com.jgefroh.hog.persistence;


public class FilePath {

    public final String path;
    
    public FilePath(final String path) {
        this.path = path;
    }
    
    public static FilePath FilePath(String path) {
        return new FilePath(path);
    }
    
    @Override
    public String toString() {
        return this.path;
    }
}
