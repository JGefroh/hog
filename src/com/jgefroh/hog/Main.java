package com.jgefroh.hog;
import static com.jgefroh.hog.fields.FieldDefinition.FieldDefinition;
import static com.jgefroh.hog.fields.FieldName.FieldName;
import static com.jgefroh.hog.fields.FieldType.FieldType;
import static com.jgefroh.hog.models.ModelDefinition.ModelDefinition;
import static com.jgefroh.hog.models.ModelName.ModelName;
import static com.jgefroh.hog.models.PackageName.PackageName;
import static com.jgefroh.hog.persistence.FilePath.FilePath;
import static com.jgefroh.hog.persistence.TextContent.TextContent;

import com.jgefroh.hog.generators.daos.DAOGenerator;
import com.jgefroh.hog.generators.daos.DAOImplGenerator;
import com.jgefroh.hog.generators.dtos.DTOGenerator;
import com.jgefroh.hog.generators.endpoints.EndpointGenerator;
import com.jgefroh.hog.generators.entities.EntityGenerator;
import com.jgefroh.hog.generators.managers.ManagerGenerator;
import com.jgefroh.hog.models.ModelDefinition;
import com.jgefroh.hog.persistence.SourceSaver;


public class Main {
    
    public static void main(String[] args) {
        ModelDefinition model = ModelDefinition(ModelName("Person"), PackageName("herp.jgefroh"));
        model.addField(FieldDefinition(FieldName("id"), FieldType("Integer")));
        model.addField(FieldDefinition(FieldName("firstName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("lastName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("location"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("phoneNumber"), FieldType("String")));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "Person.java"), TextContent(new EntityGenerator().generate(model)));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "PersonDTO.java"), TextContent(new DTOGenerator().generate(model)));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "PersonEndpoint.java"), TextContent(new EndpointGenerator().generate(model)));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "PersonManager.java"), TextContent(new ManagerGenerator().generate(model)));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "PersonDAO.java"), TextContent(new DAOGenerator().generate(model)));
        SourceSaver.save(FilePath(model.getPackageName().asRelativePath() + "PersonDAOImpl.java"), TextContent(new DAOImplGenerator().generate(model)));
    }

}
