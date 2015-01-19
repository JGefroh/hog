package com.jgefroh.hog.generators.core;

import java.util.HashMap;
import java.util.Map;

import com.jgefroh.hog.generators.util.FormatUtil;


public class CodeTemplate {

    private Map<String, Object> parameters = new HashMap<String, Object>();
    private String templatePath = null;
    private String outputFileName = null;
    
    private CodeTemplate() {
    }
    
    public CodeTemplate(final String templatePath, final String outputFileName) {
        put("FormatUtil", FormatUtil.class);
        this.templatePath = templatePath;
        this.outputFileName = outputFileName;
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
    
    
    public String getOutputPath() {
        return outputFileName;
    }
    
    public String getTemplatePath() {
        return templatePath;
    }
}

