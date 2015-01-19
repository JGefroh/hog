package com.jgefroh.hog.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.jgefroh.hog.HighlyOpinionatedGenerator;
import com.jgefroh.hog.core.FieldDefinition;
import com.jgefroh.hog.core.ModelDefinition;
import com.jgefroh.pig.PracticalInterfaceGenerator;


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
        frame = new JFrame("HOG - Highly Opinionated Generator v0.0.2 by Joseph Gefroh");
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
        
        JButton hogButton = new JButton("Generate with HOG");
        hogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                generateHOG(modelName.getText(), packageName.getText(), fieldForms);
            }
        });
        buttonPanel.add(hogButton);   
        
        JButton pigButton = new JButton("Generate with PIG");
        pigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                generatePIG(modelName.getText(), packageName.getText(), fieldForms);
            }
        });
        buttonPanel.add(pigButton);
        
        mainPanel.add(buttonPanel);
        mainPanel.validate();
    }
    
    
    private void createAndShowForm() {
        final FieldDefinitionForm form = new FieldDefinitionForm();
        form.addRemoveClickedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(form.getPanel());
                fieldForms.remove(form);
                frame.validate();
            }
        });
        
        fieldForms.add(form);
        mainPanel.add(form.getPanel());
        frame.validate();
    }
    
    private void generateHOG(final String modelName, final String packageName, final List<FieldDefinitionForm> forms) {
        ModelDefinition model = prepareModel(modelName, packageName, forms);
        HighlyOpinionatedGenerator generator = new HighlyOpinionatedGenerator();
        generator.generate(model);
    }
    
    private void generatePIG(final String modelName, final String packageName, final List<FieldDefinitionForm> forms) {
        ModelDefinition model = prepareModel(modelName, packageName, forms);
        PracticalInterfaceGenerator pig = new PracticalInterfaceGenerator();
        pig.generate(model);
    }
    
    private ModelDefinition prepareModel(final String modelName, final String packageName, final List<FieldDefinitionForm> forms) {
        ModelDefinition model = new ModelDefinition(modelName, packageName);

        for (FieldDefinitionForm form : forms) {
            model.addField(new FieldDefinition(form.getName(), form.getType(), form.getAttribute()));
        }
        
        return model;
    }
}
