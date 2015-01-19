package com.jgefroh.hog.generators.core;

import java.util.HashMap;
import java.util.Map;

import com.jgefroh.hog.generators.util.FormatUtil;


public abstract class CodeTemplate {

    private Map<String, Object> parameters = new HashMap<String, Object>();

    public CodeTemplate() {
        put("FormatUtil", FormatUtil.class);
    }
    
    public Map<String, Object> getParameters() {
        return this.parameters;
    }
    
    public void put(final String key, final Object object) {
        this.parameters.put(key, object);
    }

    public Object get(final String key) {
        return parameters.get(key);
    }
    
    public abstract String getPath();
}

