package com.jgefroh.pig;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jgefroh.hog.core.AbstractCodeGenerator;
import com.jgefroh.hog.core.CodeTemplate;
import com.jgefroh.hog.core.ModelDefinition;
import com.jgefroh.hog.templates.FormatUtil;

/**
 * PIG is the Practical Interface Generator.
 * 
 * It is an add-on to HOG and does the same thing except for the interface.
 * It auto-generates an AngularJS 1.2 interface to allow for CRUD operations.
 * It is intended to be used with HOG.
 * @author Joseph Gefroh
 * @date 01/18/2015
 */
public class PracticalInterfaceGenerator extends AbstractCodeGenerator {
    
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public void generate(ModelDefinition model) {
        logger.info("Generating...");
        String baseOutputPath = "generated\\app\\src\\modules\\" + FormatUtil.pluralize(model.getName().toString().toLowerCase()) + "\\" +  model.getName();
        
        List<CodeTemplate> templates = new ArrayList<CodeTemplate>();
        templates.add(new CodeTemplate("com/jgefroh/pig/service_template.vm", baseOutputPath + "Service.js"));
        templates.add(new CodeTemplate("com/jgefroh/pig/module_template.vm", baseOutputPath + "Module.js"));
        templates.add(new CodeTemplate("com/jgefroh/pig/routes_template.vm", baseOutputPath + "Routes.js"));
        templates.add(new CodeTemplate("com/jgefroh/pig/selection_view_template.vm", baseOutputPath + "SelectionView.html"));
        templates.add(new CodeTemplate("com/jgefroh/pig/selection_controller_template.vm", baseOutputPath + "SelectionController.js"));
        templates.add(new CodeTemplate("com/jgefroh/pig/edit_view_template.vm", baseOutputPath + "EditView.html"));
        templates.add(new CodeTemplate("com/jgefroh/pig/edit_controller_template.vm", baseOutputPath + "EditController.js"));
        
        generate(templates, model);
        
        logger.info("Finished generating.");
    }
}
