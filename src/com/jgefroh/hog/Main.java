package com.jgefroh.hog;
import static com.jgefroh.hog.fields.FieldDefinition.FieldDefinition;
import static com.jgefroh.hog.fields.FieldName.FieldName;
import static com.jgefroh.hog.fields.FieldType.FieldType;
import static com.jgefroh.hog.models.ModelDefinition.ModelDefinition;
import static com.jgefroh.hog.models.ModelName.ModelName;

import com.jgefroh.hog.generators.daos.DAOGenerator;
import com.jgefroh.hog.generators.daos.DAOImplGenerator;
import com.jgefroh.hog.generators.dtos.DTOGenerator;
import com.jgefroh.hog.generators.endpoints.EndpointGenerator;
import com.jgefroh.hog.generators.entities.EntityGenerator;
import com.jgefroh.hog.generators.managers.ManagerGenerator;
import com.jgefroh.hog.models.ModelDefinition;


public class Main {
    
    public static void main(String[] args) {
        ModelDefinition model = ModelDefinition(ModelName("Person"));
        model.addField(FieldDefinition(FieldName("id"), FieldType("Integer")));
        model.addField(FieldDefinition(FieldName("firstName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("lastName"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("location"), FieldType("String")));
        model.addField(FieldDefinition(FieldName("phoneNumber"), FieldType("String")));
        
        
        
        System.out.println("\n------------------Generated entity is : ");
        System.out.println(new EntityGenerator().generate(model));

        
        System.out.println("\n------------------Generated DTO is : ");
        System.out.println(new DTOGenerator().generate(model));
        
        
        System.out.println("\n------------------Generated Endpoint is : ");
        System.out.println(new EndpointGenerator().generate(model));
        
        System.out.println("\n------------------Generated Manager is : ");
        System.out.println(new ManagerGenerator().generate(model));
        

        System.out.println("\n------------------Generated DAO is : ");
        System.out.println(new DAOGenerator().generate(model));
        
        System.out.println("\n------------------Generated DAOImpl is : ");
        System.out.println(new DAOImplGenerator().generate(model));
        
    }

}
