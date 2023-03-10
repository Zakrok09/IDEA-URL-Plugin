package com.example.urlplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class WebView implements ToolWindowFactory {

    /**
     * Overriding the createToolWindowContent to load the browser.
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        BrowserService bs = project.getService(BrowserService.class);
        var contentFactory = ContentFactory.SERVICE.getInstance();
        JPanel myPanel = new JPanel();
        myPanel.add(bs.browser.getComponent());
        var content = contentFactory.createContent(myPanel, "Webview", false);
        toolWindow.getContentManager().addContent(content);
    }
}
