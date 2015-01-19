package com.jgefroh.hog.generators.daos;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


/**
 * Generates a highly opinionated DTO.
 * @author Joseph Gefroh
 *
 */
public class DAOGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        DAOTemplate template = new DAOTemplate();
        template.put("model", model);
        return generate(template);
    }
}
