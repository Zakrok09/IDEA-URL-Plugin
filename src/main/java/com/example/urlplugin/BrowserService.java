package com.example.urlplugin;

import com.intellij.openapi.components.Service;
import com.intellij.ui.jcef.JBCefBrowser;

@Service(Service.Level.PROJECT)
public class BrowserService {

    public JBCefBrowser browser;

    public BrowserService() {
        this.browser = new JBCefBrowser("https://www.youtube.com/watch?v=W86cTIoMv2U");
    }

}