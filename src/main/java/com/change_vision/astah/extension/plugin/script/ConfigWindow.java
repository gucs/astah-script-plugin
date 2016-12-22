package com.change_vision.astah.extension.plugin.script;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.change_vision.astah.extension.plugin.script.util.Messages;

public class ConfigWindow extends JDialog implements ActionListener {
    public ConfigWindow() {
        setLayout(new BorderLayout());
        
        JPanel componentPanel = new JPanel();
        JPanel southBtnPanel = new JPanel();
        
        componentPanel.setLayout(new GridBagLayout());
        //southBtnPanel.setLayout(new BoxLayout(southBtnPanel, BoxLayout.X_AXIS));
        southBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        add("Center", componentPanel);
        add("South", southBtnPanel);
        
        JCheckBox ckbox = new JCheckBox(Messages.getMessage("config.clear_console"));
        //ckbox.addActionListener(this);
           
        JButton okBtn = new JButton(Messages.getMessage("config.ok.button"));
        okBtn.addActionListener(this);
        okBtn.setActionCommand("okBtn");
        
        JButton cancelBtn = new JButton(Messages.getMessage("config.cancel.button"));
        cancelBtn.addActionListener(this);
        cancelBtn.setActionCommand("cancelBtn");
        
        componentPanel.add(ckbox);
        southBtnPanel.add(okBtn);
        southBtnPanel.add(cancelBtn);
        
        setTitle(Messages.getMessage("action.config.label"));
        setSize(400, 300);
        setLocationRelativeTo(null);
     }
     
     public void actionPerformed(ActionEvent e) {
         String cmd = e.getActionCommand();

         if (cmd.equals("okBtn")) {
             java.lang.System.out.println("OK!!!");
         } else if (cmd.equals("cancelBtn")) {
             java.lang.System.out.println("Cancel...");
         }
         
         /*
         JCheckBox checkbox = (JCheckBox)e.getSource();
         if (checkbox.isSelected()) {
             java.lang.System.out.println("check in");
         } else {
             java.lang.System.out.println("check out");
         }
         */
         
     }
}