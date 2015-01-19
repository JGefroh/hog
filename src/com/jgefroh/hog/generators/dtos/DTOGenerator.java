package com.jgefroh.hog.generators.dtos;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


/**
 * Generates a highly opinionated DTO.
 * @author Joseph Gefroh
 *
 */
public class DTOGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        DTOTemplate template = new DTOTemplate();
        template.put("model", model);
        return generate(template);
    }
}
