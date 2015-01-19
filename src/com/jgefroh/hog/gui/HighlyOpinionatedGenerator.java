package com.jgefroh.hog.gui;

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


public class HighlyOpinionatedGenerator {

    public void generate(ModelDefinition model) {
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + ".java"), TextContent(new EntityGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + "DTO.java"), TextContent(new DTOGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + "Endpoint.java"), TextContent(new EndpointGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + "Manager.java"), TextContent(new ManagerGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + "DAO.java"), TextContent(new DAOGenerator().generate(model)));
        SourceSaver.save(FilePath("generated\\" + model.getPackageName().asRelativePath() + model.getName() + "DAOImpl.java"), TextContent(new DAOImplGenerator().generate(model)));
    }

}
