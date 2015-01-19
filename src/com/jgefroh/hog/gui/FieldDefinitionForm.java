package com.jgefroh.hog.gui;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgefroh.hog.fields.FieldAttribute;


public class FieldDefinitionForm {
    private JPanel panel;
    private JTextField name;
    private JTextField type;
    private JComboBox<FieldAttribute> attribute;
    public FieldDefinitionForm() {
        name = new JTextField(15);
        type = new JTextField(15);
        attribute = new JComboBox<FieldAttribute>();
        
        for (FieldAttribute attr : FieldAttribute.values()) {
            attribute.addItem(attr);
        }

        panel = new JPanel();
        panel.setMaximumSize(new Dimension(800, 30));
        
        panel.add(new JLabel("Field Name"));
        panel.add(name);
        
        panel.add(new JLabel("Field Type"));
        panel.add(type);
        
        panel.add(new JLabel("Field Attribute"));
        panel.add(attribute);
    }
    
    public JPanel getPanel() {
        return this.panel;
    }

    public String getName() {
        return name.getText();
    }

    public String getType() {
        return type.getText();
    }

    public FieldAttribute getAttribute() {
        return attribute.getItemAt(attribute.getSelectedIndex());
    }
}
