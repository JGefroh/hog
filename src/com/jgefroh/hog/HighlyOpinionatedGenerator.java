package com.jgefroh.hog;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.jgefroh.hog.core.CodeTemplate;
import com.jgefroh.hog.core.ModelDefinition;
import com.jgefroh.hog.core.SourceSaver;

/**
 * @author Joseph Gefroh
 */
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
        
        
        for (CodeTemplate template : templates) {
            logger.info(String.format("...Generating code using template %s.", template.getTemplatePath()));
            template.put("model", model);
            try {
                SourceSaver.save(template.getOutputPath(), generateSourceCode(template));
            }
            catch(Exception e) {
                logger.severe(String.format("...error while generating %s - skipping. [error: '%s']", template.getTemplatePath(), e.getMessage()));
            }
        }
        logger.info("Finished generating.");
    }
    
    
    private String generateSourceCode(final CodeTemplate template) {
        initializeVelocityEngine();
        VelocityContext context = initializeVelocityContext(template.getParameters());
        return merge(context, template.getTemplatePath());
    }
    
    private void initializeVelocityEngine() {
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init();
    }
    
    private VelocityContext initializeVelocityContext(final Map<String, Object> parameters) {
        VelocityContext context = new VelocityContext(parameters);
        context.attachEventCartridge(new EventCartridge());
        context.getEventCartridge().addEventHandler(new ReferenceInsertionEventHandler() {
            @Override
            public Object referenceInsert(final String reference, final Object value) {
                //[JG]: Replace null with blank in templates
                return value == null ? "" : value;
            }
        });
        
        return context;
    }
    
    private String merge(final VelocityContext context, final String templatePath) {
        Template velocityTemplate = Velocity.getTemplate(templatePath);
        StringWriter writer = new StringWriter();
        velocityTemplate.merge(context, writer);
        return writer.toString();
    }
}
