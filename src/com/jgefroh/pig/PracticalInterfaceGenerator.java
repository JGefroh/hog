package com.jgefroh.pig;

import static com.jgefroh.hog.persistence.FilePath.FilePath;
import static com.jgefroh.hog.persistence.TextContent.TextContent;

import com.jgefroh.hog.generators.util.FormatUtil;
import com.jgefroh.hog.models.ModelDefinition;
import com.jgefroh.hog.persistence.SourceSaver;
import com.jgefroh.pig.generators.services.ServiceGenerator;


public class PracticalInterfaceGenerator {
    public void generate(ModelDefinition model) {
        SourceSaver.save(FilePath("generated\\app\\src\\modules\\" + FormatUtil.pluralize(model.getName().toString().toLowerCase()) + "\\" +  model.getName() + "Service.js"), TextContent(new ServiceGenerator().generate(model)));
    }
}
