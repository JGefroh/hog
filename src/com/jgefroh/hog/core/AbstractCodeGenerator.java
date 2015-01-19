package com.jgefroh.hog.core;

import java.io.StringWriter;
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


public abstract class AbstractCodeGenerator {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    
    
    public void generate(final List<CodeTemplate> templates, final ModelDefinition model) {
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
