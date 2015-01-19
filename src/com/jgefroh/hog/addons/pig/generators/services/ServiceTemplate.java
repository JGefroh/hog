package com.jgefroh.hog.addons.pig.generators.services;

import com.jgefroh.hog.generators.core.CodeTemplate;


public class ServiceTemplate extends CodeTemplate {
    
    public ServiceTemplate(String templatePath, String outputFileName) {
        super(templatePath, outputFileName);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTemplatePath() {
        return "com/jgefroh/pig/generators/services/service_template.vm";
    }

}
