package com.example.urlplugin.actions;

import com.example.urlplugin.Modal;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class URLModal extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Modal urlModal = new Modal();
        urlModal.showAndGet();
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
