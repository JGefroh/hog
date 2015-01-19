package com.jgefroh.hog.generators.managers;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


public class ManagerGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        ManagerTemplate template = new ManagerTemplate();
        template.put("model", model);
        return generate(template);
    }
}
