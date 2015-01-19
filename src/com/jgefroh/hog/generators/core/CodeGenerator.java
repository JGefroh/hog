package com.jgefroh.hog.generators.core;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class CodeGenerator {
    public String generate(final CodeTemplate template) {
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init();
        VelocityContext context = new VelocityContext(template.getParameters());
        context.attachEventCartridge(new EventCartridge());
        context.getEventCartridge().addEventHandler(new ReferenceInsertionEventHandler() {
            @Override
            public Object referenceInsert(String reference, Object value) {
                if (value == null) {
                    return "";
                }
                return value;
            }
        });
        Template velTemplate = Velocity.getTemplate(template.getPath());
        StringWriter writer = new StringWriter();
        velTemplate.merge(context, writer);
        return writer.toString();
    }
}
