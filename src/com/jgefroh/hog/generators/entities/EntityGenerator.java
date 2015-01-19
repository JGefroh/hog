package com.jgefroh.hog.generators.entities;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.models.ModelDefinition;



/**
 * Generates a highly opinionated JPA entity.
 * @author Joseph Gefroh
 *
 */
public class EntityGenerator extends CodeGenerator {
    
    public String generate(final ModelDefinition model) {
        EntityTemplate template = new EntityTemplate();
        template.put("model", model);
        return generate(template);
    }
    
}
