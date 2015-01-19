package com.jgefroh.hog;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jgefroh.hog.core.AbstractCodeGenerator;
import com.jgefroh.hog.core.CodeTemplate;
import com.jgefroh.hog.core.ModelDefinition;
import com.jgefroh.hog.core.SourceSaver;

/**
 * HOG is the Highly Opinionated Generator.
 * 
 * It generates code based on practical needs that I've encountered.
 * Sometimes it follows best practices, other times it doesn't because the situation
 * the generator was created for doesn't allow it or I don't know what the best practice is.
 * @author Joseph Gefroh
 * @date 01/18/2015
 */
public class HighlyOpinionatedGenerator extends AbstractCodeGenerator {
    
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public void generate(ModelDefinition model) {
        logger.info("Generating...");
        String baseOutputPath = "generated\\" + model.getPackageName().replace(".", "\\") + "\\" + model.getName();
        
        List<CodeTemplate> templates = new ArrayList<CodeTemplate>();
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/entity_template.vm", baseOutputPath + ".java"));
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/dto_template.vm", baseOutputPath + "DTO.java"));
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/endpoint_template.vm", baseOutputPath + "Endpoint.java"));
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/manager_template.vm", baseOutputPath + "Manager.java"));
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/dao_template.vm", baseOutputPath + "DAO.java"));
        templates.add(new CodeTemplate("com/jgefroh/hog/templates/daoimpl_template.vm", baseOutputPath + "DAOImpl.java"));
        
        generate(templates, model);
        
        logger.info("Finished generating.");
    }
    
}
