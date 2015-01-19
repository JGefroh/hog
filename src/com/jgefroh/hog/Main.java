package com.jgefroh.hog;
import static com.jgefroh.hog.fields.FieldDefinition.FieldDefinition;
import static com.jgefroh.hog.fields.FieldName.FieldName;
import static com.jgefroh.hog.fields.FieldType.FieldType;
import static com.jgefroh.hog.models.ModelDefinition.ModelDefinition;
import static com.jgefroh.hog.models.ModelName.ModelName;
import static com.jgefroh.hog.models.PackageName.PackageName;
import static com.jgefroh.hog.persistence.FilePath.FilePath;
import static com.jgefroh.hog.persistence.TextContent.TextContent;

import com.jgefroh.hog.fields.FieldAttribute;
import com.jgefroh.hog.generators.daos.DAOGenerator;
import com.jgefroh.hog.generators.daos.DAOImplGenerator;
import com.jgefroh.hog.generators.dtos.DTOGenerator;
import com.jgefroh.hog.generators.endpoints.EndpointGenerator;
import com.jgefroh.hog.generators.entities.EntityGenerator;
import com.jgefroh.hog.generators.managers.ManagerGenerator;
import com.jgefroh.hog.gui.MainWindow;
import com.jgefroh.hog.models.ModelDefinition;
import com.jgefroh.hog.persistence.SourceSaver;


public class Main {
    
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }

}
