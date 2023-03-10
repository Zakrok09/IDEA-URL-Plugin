package com.example.urlplugin;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.jcef.JBCefApp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Modal extends DialogWrapper {
    private final Action openLink1;
    private final Action openLink2;

    public Modal() {
        super(true);

        // If JBCef is not supported, then the urls shall be opened in the browser
        if (!JBCefApp.isSupported()) {
            this.openLink1 = new DialogWrapperAction("Open URL 1") {
                @Override
                protected void doAction(ActionEvent e) {
                    BrowserUtil.browse("https://www.youtube.com/watch?v=hWvM6de6mG8");
                }
            };

            this.openLink2 = new DialogWrapperAction("Open URL 2") {
                @Override
                protected void doAction(ActionEvent e) {
                    BrowserUtil.browse("https://www.youtube.com/watch?v=W86cTIoMv2U");
                }
            };
        } else {
            //If JBCef is indeed supported, they will be opened with it itself.
            BrowserService bs = ApplicationManager.getApplication().getService(BrowserService.class);
            this.openLink1 = new DialogWrapperAction("Open URL 1") {
                @Override
                protected void doAction(ActionEvent e) {
                    bs.browser.loadURL("https://www.youtube.com/watch?v=nl8o9PsJPAQ");
                }
            };

            this.openLink2 = new DialogWrapperAction("Open URL 2") {
                @Override
                protected void doAction(ActionEvent e) {
                    bs.browser.loadURL("https://www.youtube.com/watch?v=W86cTIoMv2U");
                }
            };
        }
        setTitle("URL Dialog Modal");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return null;
    }

    @Override
    protected Action @NotNull [] createActions() {
        return new Action[]{openLink1, openLink2};
    }
}
