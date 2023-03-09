package com.example.urlplugin;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Modal extends DialogWrapper {

    public Modal() {
        super(true);
        setTitle("URL Dialog Modal");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return null;
    }
}
