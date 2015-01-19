package com.jgefroh.pig.generators.services;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


/**
 * Generates a highly opinionated DTO.
 * @author Joseph Gefroh
 *
 */
public class ServiceGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        ServiceTemplate template = new ServiceTemplate();
        template.put("model", model);
        return generate(template);
    }
}
