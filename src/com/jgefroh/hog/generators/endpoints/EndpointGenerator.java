package com.jgefroh.hog.generators.endpoints;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


public class EndpointGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        EndpointTemplate template = new EndpointTemplate();
        template.put("model", model);
        return generate(template);
    }
}
