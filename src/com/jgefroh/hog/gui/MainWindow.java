package com.jgefroh.hog.gui;

import static com.jgefroh.hog.fields.FieldDefinition.FieldDefinition;
import static com.jgefroh.hog.fields.FieldName.FieldName;
import static com.jgefroh.hog.fields.FieldType.FieldType;
import static com.jgefroh.hog.models.ModelDefinition.ModelDefinition;
import static com.jgefroh.hog.models.ModelName.ModelName;
import static com.jgefroh.hog.models.PackageName.PackageName;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.jgefroh.hog.fields.FieldAttribute;
import com.jgefroh.hog.models.ModelDefinition;


public class MainWindow {
    
    private List<FieldDefinitionForm> fieldForms = new ArrayList<FieldDefinitionForm>();
    private JPanel mainPanel;
    private JFrame frame;
    
    private JTextField modelName;
    private JTextField packageName;
    
    public MainWindow() {
        createFrameAndMainPanels();
        createModelAndPackageForm();
        createButtons();
        createAndShowForm();
    }
    

    private void createModelAndPackageForm() {
        JPanel modelInput = new JPanel();
        modelInput.setMaximumSize(new Dimension(800, 30));
        modelName = new JTextField(15);
        packageName = new JTextField(15);
        
        modelInput.add(new JLabel("Model Name"));
        modelInput.add(modelName);
        
        modelInput.add(new JLabel("Package Name"));
        modelInput.add(packageName);
        mainPanel.add(modelInput);
    }


    private void createFrameAndMainPanels() {
        frame = new JFrame("HOG - Highly Opinionated Generator by Joseph Gefroh");
        frame.setSize(800, 600);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setMaximumSize(new Dimension(800, 600));
        frame.add(scrollPane);
    }
    
    private void createButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(800, 30));
        
        JButton addFieldButton = new JButton("Add Field");
        addFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createAndShowForm();
            }
        });
        buttonPanel.add(addFieldButton);
        
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                generate(modelName.getText(), packageName.getText(), fieldForms);
            }
        });
        buttonPanel.add(generateButton);
        
        mainPanel.add(buttonPanel);
        mainPanel.validate();
    }
    
    
    private void createAndShowForm() {
        FieldDefinitionForm form = new FieldDefinitionForm();
        fieldForms.add(form);
        mainPanel.add(form.getPanel());
        frame.validate();
    }
    
    private void generate(final String modelName, final String packageName, final List<FieldDefinitionForm> forms) {
        ModelDefinition model = ModelDefinition(ModelName(modelName), PackageName(packageName));

        for (FieldDefinitionForm form : forms) {
            model.addField(FieldDefinition(FieldName(form.getName()), FieldType(form.getType()), form.getAttribute()));
        }
        
        HighlyOpinionatedGenerator generator = new HighlyOpinionatedGenerator();
        generator.generate(model);
    }
}
