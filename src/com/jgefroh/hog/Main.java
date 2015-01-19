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
import com.jgefroh.hog.models.ModelDefinition;
import com.jgefroh.hog.persistence.SourceSaver;


public class Main {
    
    public static void main(String[] args) {
        ModelDefinition model = ModelDefinition(ModelName("Person"), PackageName("herp.jgefroh"));
        model.addField(FieldDefinition(FieldName("id"), FieldType("Integer"), FieldAttribute.ID));
        model.addField(FieldDefinition(FieldName("firstName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("lastName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("location"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("money"), FieldType("BigDecimal")));
        model.addField(FieldDefinition(FieldName("coordinate"), FieldType("double")));
        model.addField(FieldDefinition(FieldName("accuracy"), FieldType("float")));
        model.addField(FieldDefinition(FieldName("isFat"), FieldType("boolean")));
        model.addField(FieldDefinition(FieldName("friendIds"), FieldType("List<Integer>"), FieldAttribute.ELEMENT_COLLECTION));
        model.addField(FieldDefinition(FieldName("bestFriend"), FieldType("Person"), FieldAttribute.MANY_TO_ONE));
        model.addField(FieldDefinition(FieldName("imaginaryFriend"), FieldType("Person"), FieldAttribute.ONE_TO_ONE));
        model.addField(FieldDefinition(FieldName("minions"), FieldType("Person"), FieldAttribute.ONE_TO_MANY));
        model.addField(FieldDefinition(FieldName("phoneNumber"), FieldType("String")));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "Person.java"), TextContent(new EntityGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "PersonDTO.java"), TextContent(new DTOGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "PersonEndpoint.java"), TextContent(new EndpointGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "PersonManager.java"), TextContent(new ManagerGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "PersonDAO.java"), TextContent(new DAOGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + "PersonDAOImpl.java"), TextContent(new DAOImplGenerator().generate(model)));
    }

}
