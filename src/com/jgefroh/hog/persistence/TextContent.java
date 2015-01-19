package com.jgefroh.hog.persistence;


public class TextContent {

    public final String content;
    
    public TextContent(final String content) {
        this.content = content;
    }
    
    public static TextContent TextContent(String content) {
        return new TextContent(content);
    }
    
    @Override
    public String toString() {
        return this.content;
    }
}
