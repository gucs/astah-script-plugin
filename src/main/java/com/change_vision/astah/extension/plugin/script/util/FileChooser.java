package com.change_vision.astah.extension.plugin.script.util;

import java.awt.Dialog;
import java.awt.FileDialog;

import javax.swing.JFileChooser;

public class FileChooser {
    private static final String OS = System.getProperty("os.name").toLowerCase();
    
    public static String chooseFileToLoad(Dialog parentDialog) {
        return chooseFile(parentDialog, Messages.getMessage("open_script_dialog.title"), FileDialog.LOAD);
    }

    public static String chooseFileToSave(Dialog parentDialog) {
        return chooseFile(parentDialog, Messages.getMessage("save_dialog.title"), FileDialog.SAVE);
    }

    private static String chooseFile(Dialog parentDialog, String title, int mode) {
        if (isMac()) {
            //For the usability
            return chooseFileByFileDialog(parentDialog, title, mode);
        } else {
            //To avoid the bug of Java(GTK + Java7 + FileDialog freezes)
            return chooseFileByJFileChooser(parentDialog, title, mode);
        }
    }
    
    private static String chooseFileByFileDialog(Dialog parentDialog, String title, int mode) {
        FileDialog fileDialog = new FileDialog(parentDialog, title, mode);
        fileDialog.setVisible(true);
        String selectedFile = fileDialog.getFile();
        if (selectedFile != null) {
            return fileDialog.getDirectory() + selectedFile;
        } else {
            return null;
        }
    }
    
    private static String chooseFileByJFileChooser(Dialog parentDialog, String title, int mode) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        int returnValue = 0;
        if (mode == FileDialog.LOAD) {
            returnValue = chooser.showOpenDialog(parentDialog);
        } else if (mode == FileDialog.SAVE) {
            returnValue = chooser.showSaveDialog(parentDialog);
        }
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
    
    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
}
