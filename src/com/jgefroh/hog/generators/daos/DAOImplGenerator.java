package com.jgefroh.hog.generators.daos;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;


/**
 * Generates a highly opinionated DTO.
 * @author Joseph Gefroh
 *
 */
public class DAOImplGenerator extends CodeGenerator {
    public String generate(final ModelDefinition model) {
        DAOImplTemplate template = new DAOImplTemplate();
        template.put("model", model);
        return generate(template);
    }
}
