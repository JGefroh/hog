package com.jgefroh.hog;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jgefroh.hog.generators.core.CodeGenerator;
import com.jgefroh.hog.generators.core.CodeTemplate;
import com.jgefroh.hog.models.ModelDefinition;
import com.jgefroh.hog.persistence.SourceSaver;


public class HighlyOpinionatedGenerator {
    
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
        
        
        CodeGenerator generator = new CodeGenerator();
        for (CodeTemplate template : templates) {
            logger.info("...Generating code using template " + template.getTemplatePath());
            template.put("model", model);
            try {
                SourceSaver.save(template.getOutputPath(), generator.generate(template));
            }
            catch(Exception e) {
                logger.severe("...error while generating " + template.getTemplatePath() + " - skipping. [error: '" + e.getMessage() + "']");
            }
        }
        logger.info("Finished generating.");
    }

}
